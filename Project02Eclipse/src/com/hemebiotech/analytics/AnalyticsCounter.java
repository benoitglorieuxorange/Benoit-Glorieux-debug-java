package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;


/**
 * The AnalyticsCounter class reads symptoms from a file, counts occurrences of specific symptoms,
 * and writes the results to an output file.
 */

public class AnalyticsCounter {
	private static int headacheCount = 0;
	private static int rashCount = 0;
	private static int pupilCount = 0;
	
	public static void main(String args[]) throws Exception {
    
    // Open and read the symptoms file
    BufferedReader reader = new BufferedReader(new FileReader("symptoms.txt"));
    String line = reader.readLine();

    int i = 0;
    int headCount = 0;
    
    // Process each line from the file
    while (line != null) {
        i++;
        System.out.println("symptom from file: " + line);
        
        // Count specific symptoms
        if (line.equals("headache")) {
            headCount++;
            System.out.println("number of headaches: " + headCount);
        } else if (line.equals("rush")) {
            rashCount++;
        } else if (line.contains("pupils")) {
            pupilCount++;
        }

        line = reader.readLine();
    }
    reader.close();
    
    // Write symptom counts to output file
    FileWriter writer = new FileWriter("result.out");
    writer.write("headache: " + headacheCount + "\n");
    writer.write("rash: " + rashCount + "\n");
    writer.write("dialated pupils: " + pupilCount + "\n");
    writer.close();
}

