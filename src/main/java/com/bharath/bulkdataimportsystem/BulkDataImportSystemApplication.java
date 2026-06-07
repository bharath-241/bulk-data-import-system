package com.bharath.bulkdataimportsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class BulkDataImportSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(
                BulkDataImportSystemApplication.class,
                args);
    }
}