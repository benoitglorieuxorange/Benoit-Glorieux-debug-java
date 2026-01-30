package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

/**
 * AnalyticsCounter analyzes a list of symptoms and provides methods to count
 * and sort them. It counts the occurrences of each symptom and can sort them
 * alphabetically.
 */

public class AnalyticsCounter {

	// List containing all symptoms to be analyzed
	private final List<String> symptomsList;

	// Constructor to initialize the symptoms list
	public AnalyticsCounter(List<String> symptomsList) {
		this.symptomsList = symptomsList;
	}

	/**	Count the occurrences of each symptom
	 *
	 * @return Map with the list of any symptoms and the count of each.
	 */

	public HashMap<String, Integer> countSymptoms() {
		// Create a map to store symptoms and their counts
		HashMap<String, Integer> symptomsMap = new HashMap<>();

		// Iterate through each symptom in the list
		for (String symptom : symptomsList) {
			// If symptom exists, increment its count; otherwise, add it with count 1
			if (symptomsMap.containsKey(symptom)) {
				symptomsMap.put(symptom, symptomsMap.get(symptom) + 1);
			} else {
				symptomsMap.put(symptom, 1);
			}
		}

		return symptomsMap;
	}

	/** Sort symptoms alphabetically
	 *
	 * @param symptomsMap
	 * @return TreeMap with symptoms and count sorted in alphabetical order
	 */
	public TreeMap<String, Integer> sortSymptoms(HashMap<String, Integer> symptomsMap) {
		return new TreeMap<>(symptomsMap);
	}
}