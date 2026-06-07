package com.bharath.bulkdataimportsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bharath.bulkdataimportsystem.entity.ImportRecord;

public interface ImportRecordRepository
        extends JpaRepository<ImportRecord, Long> {

    List<ImportRecord> findByStatus(String status);
}