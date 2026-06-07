package com.bharath.bulkdataimportsystem.dto;

public class ImportRequestDto {

    private String fileName;

    public ImportRequestDto() {
    }

    public ImportRequestDto(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}