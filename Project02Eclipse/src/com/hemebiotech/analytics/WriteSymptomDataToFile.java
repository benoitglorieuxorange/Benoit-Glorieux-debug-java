package com.hemebiotech.analytics;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Responsible for writing sorted symptom data to a file named "result.out".
 * Takes a TreeMap of symptoms and their counts, and writes each entry to the file.
 */


public class WriteSymptomDataToFile implements ISymptomWriter {

    private final TreeMap<String, Integer> sortedSymptoms;
    private static final Logger logger = Logger.getLogger(WriteSymptomDataToFile.class.getName());

    // Constructor to initialize the sorted symptoms map
    public WriteSymptomDataToFile(TreeMap<String, Integer> sortedSymptoms) {
        this.sortedSymptoms = sortedSymptoms;
    }

    // Write symptoms and their counts to a file
    @Override
    public void WriteSymptoms() {
        final String FILE_NAME = "result.out";

        // Automatically close the writer after use
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            // Write each symptom with its count on a new line
            for (Map.Entry<String, Integer> entry : sortedSymptoms.entrySet()) {
                writer.write(entry.getKey() + " : " + entry.getValue());
                writer.newLine();
            }

        } catch (IOException e) {
            logger.severe("Error occurred : " + e.getMessage());
            // or more details
            logger.log(Level.SEVERE, "Exception catch", e);
        }
    }

}