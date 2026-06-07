package com.bharath.bulkdataimportsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bharath.bulkdataimportsystem.entity.ImportJob;

public interface ImportJobRepository
        extends JpaRepository<ImportJob, Long> {

    List<ImportJob> findAllByFileName(String fileName);

}