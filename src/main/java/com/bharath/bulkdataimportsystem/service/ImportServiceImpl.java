package com.bharath.bulkdataimportsystem.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bharath.bulkdataimportsystem.entity.ImportJob;
import com.bharath.bulkdataimportsystem.entity.ImportRecord;
import com.bharath.bulkdataimportsystem.repository.ImportJobRepository;
import com.bharath.bulkdataimportsystem.repository.ImportRecordRepository;
import com.bharath.bulkdataimportsystem.util.CsvValidator;

@Service
public class ImportServiceImpl implements ImportService {

    @Autowired
    private ImportRecordRepository importRecordRepository;

    @Autowired
    private ImportJobRepository importJobRepository;

    @Override
    public String uploadFile() {
        return "CSV Upload Service Ready";
    }

    @Override
    @Async
    public String uploadCsvFile(MultipartFile file) {

        try {

            if (!importJobRepository
                    .findAllByFileName(
                            file.getOriginalFilename())
                    .isEmpty()) {

                return "File Already Imported";
            }

            BufferedReader reader =
                    new BufferedReader(
                            new InputStreamReader(
                                    file.getInputStream()));

            String line;

            int successCount = 0;
            int failedCount = 0;

            boolean headerSkipped = false;

            while ((line = reader.readLine()) != null) {

                if (!headerSkipped) {
                    headerSkipped = true;
                    continue;
                }

                if (!CsvValidator.isValid(line)) {

                    ImportRecord invalidRecord =
                            new ImportRecord();

                    invalidRecord.setData(line);
                    invalidRecord.setStatus("FAILED");
                    invalidRecord.setErrorMessage(
                            "Invalid CSV Format");

                    importRecordRepository.save(
                            invalidRecord);

                    failedCount++;
                    continue;
                }

                ImportRecord record =
                        new ImportRecord();

                record.setData(line);
                record.setStatus("SUCCESS");

                importRecordRepository.save(record);

                successCount++;
            }

            ImportJob job = new ImportJob();

            job.setFileName(
                    file.getOriginalFilename());

            job.setTotalRecords(
                    successCount + failedCount);

            job.setSuccessRecords(
                    successCount);

            job.setFailedRecords(
                    failedCount);

            job.setStatus("COMPLETED");

            importJobRepository.save(job);

            return "Import Completed : Success = "
                    + successCount
                    + " Failed = "
                    + failedCount;

        } catch (Exception e) {

            return "Error : "
                    + e.getMessage();
        }
    }

    @Override
    public List<ImportJob> getImportHistory() {
        return importJobRepository.findAll();
    }

    @Override
    public ImportJob getImportJobById(Long id) {
        return importJobRepository
                .findById(id)
                .orElse(null);
    }

    @Override
    public List<ImportRecord> getAllRecords() {
        return importRecordRepository.findAll();
    }

    @Override
    public List<ImportRecord> getFailedRecords() {
        return importRecordRepository
                .findByStatus("FAILED");
    }
}