package com.bharath.bulkdataimportsystem.service;

import java.util.List;

import org.springframework.scheduling.annotation.Async;
import org.springframework.web.multipart.MultipartFile;

import com.bharath.bulkdataimportsystem.entity.ImportJob;
import com.bharath.bulkdataimportsystem.entity.ImportRecord;

public interface ImportService {

    String uploadFile();

    @Async
    String uploadCsvFile(MultipartFile file);

    List<ImportJob> getImportHistory();

    ImportJob getImportJobById(Long id);

    List<ImportRecord> getAllRecords();

    List<ImportRecord> getFailedRecords();
}