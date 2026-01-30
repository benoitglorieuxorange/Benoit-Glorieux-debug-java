package com.hemebiotech.analytics;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;


public class WriteSymptomDataToFile {

    private TreeMap<String, Integer> sortedSymptoms;

    // Constructor to initialize the sorted symptoms map
    public WriteSymptomDataToFile(TreeMap<String, Integer> sortedSymptoms) {
        this.sortedSymptoms = sortedSymptoms;
    }

    // Write symptoms and their counts to a file
    public void WriteSymptoms() {
        final String FILE_NAME = "result.out";

        File file = new File(FILE_NAME);

        // Automatically close the writer after use
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            // Write each symptom with its count on a new line
            for (Map.Entry<String, Integer> entry : sortedSymptoms.entrySet()) {
                writer.write(entry.getKey() + " : " + entry.getValue());
                writer.newLine();
            }
            System.out.println("HashMap successfully write in file : " + FILE_NAME);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
