package com.bharath.bulkdataimportsystem.dto;

public class ImportResponseDto {

    private String message;
    private int successCount;
    private int failedCount;

    public ImportResponseDto() {
    }

    public ImportResponseDto(String message, int successCount, int failedCount) {
        this.message = message;
        this.successCount = successCount;
        this.failedCount = failedCount;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getSuccessCount() {
        return successCount;
    }

    public void setSuccessCount(int successCount) {
        this.successCount = successCount;
    }

    public int getFailedCount() {
        return failedCount;
    }

    public void setFailedCount(int failedCount) {
        this.failedCount = failedCount;
    }
}