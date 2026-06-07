package com.bharath.bulkdataimportsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.bharath.bulkdataimportsystem.entity.ImportJob;
import com.bharath.bulkdataimportsystem.entity.ImportRecord;
import com.bharath.bulkdataimportsystem.service.ImportService;

@RestController
@RequestMapping("/api/import")
public class ImportController {

    @Autowired
    private ImportService importService;

    @GetMapping("/test")
    public String test() {
        return "Import API Working";
    }

    @PostMapping(
            value = "/upload",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String uploadFile(
            @RequestParam("file") MultipartFile file) {

        return importService.uploadCsvFile(file);
    }

    @GetMapping("/history")
    public List<ImportJob> getImportHistory() {
        return importService.getImportHistory();
    }

    @GetMapping("/history/{id}")
    public ImportJob getImportJobById(
            @PathVariable Long id) {

        return importService.getImportJobById(id);
    }

    @GetMapping("/records")
    public List<ImportRecord> getAllRecords() {
        return importService.getAllRecords();
    }

    @GetMapping("/failed")
    public List<ImportRecord> getFailedRecords() {
        return importService.getFailedRecords();
    }
}