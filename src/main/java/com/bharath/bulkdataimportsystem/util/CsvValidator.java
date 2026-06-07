package com.bharath.bulkdataimportsystem.util;

public class CsvValidator {

    public static boolean isValid(String line) {

        if (line == null || line.isBlank()) {
            return false;
        }

        String[] data = line.split(",");

        if (data.length != 3) {
            return false;
        }

        if (data[0].isBlank()) {
            return false;
        }

        if (data[1].isBlank()) {
            return false;
        }

        if (!data[1].contains("@")) {
            return false;
        }

        if (data[2].isBlank()) {
            return false;
        }

        return true;
    }
}