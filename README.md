# Bulk Data Import System

## Project Overview

Bulk Data Import System is a Spring Boot application used to upload CSV files, validate records, store successful and failed records, and maintain import history.

## Features

* CSV File Upload
* Record Validation
* Success and Failed Record Tracking
* Import History API
* Failed Records API
* Duplicate File Detection
* Async Processing
* Batch Processing
* Swagger Integration

## Technologies Used

* Java 17
* Spring Boot
* Spring Data JPA
* MySQL
* Maven
* Swagger OpenAPI

## APIs

### Upload CSV

POST /api/import/upload

### Import History

GET /api/import/history

### Import Job By ID

GET /api/import/history/{id}

### All Records

GET /api/import/records

### Failed Records

GET /api/import/failed

## Database Tables

### import_job

* id
* file_name
* status
* total_records
* success_records
* failed_records

### import_record

* id
* data
* status
* error_message

## Author

Bharath Kumar
## Swagger UI

http://localhost:8080/swagger-ui/index.html
