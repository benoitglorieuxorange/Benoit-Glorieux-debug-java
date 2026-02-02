package com.hemebiotech.analytics;

import java.awt.*;
import java.io.IOException;
import java.util.*;
import java.util.List;

/**
 * Main class to read symptoms from a file, analyze their occurrences,
 * sort them alphabetically, and save the sorted data to a file.
 */

public class Main {

    public static void main(String[] args) throws IOException {

        // Create a reader to read symptoms from a file
        ISymptomReader reader = new ReadSymptomDataFromFile("symptoms.txt");

        // Store the list of symptoms read from the file
        List<String> symptoms = reader.GetSymptoms();

        // Count the occurrences of each symptom
        Map<String, Integer> countedSymptoms = new AnalyticsCounter(symptoms).countSymptoms();

        // Sort symptoms alphabetically
        TreeMap<String, Integer> sortedSymptoms = new TreeMap<>(countedSymptoms);

        // Print the count of each symptom
        System.out.println("Symptoms count: " + countedSymptoms);
        // Print the sorted list of symptoms
        System.out.println("Symptoms sorted: " + sortedSymptoms);

        // Create a file writer to save the sorted symptoms
        WriteSymptomDataToFile writer = new WriteSymptomDataToFile(sortedSymptoms);
        // Write the symptoms to the file
        writer.WriteSymptoms();

    }

}
