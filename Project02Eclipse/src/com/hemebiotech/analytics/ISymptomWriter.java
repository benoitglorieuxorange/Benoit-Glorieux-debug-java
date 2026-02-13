package com.hemebiotech.analytics;

/**
 * Writes the symptoms to the appropriate storage system.
 * This method is responsible for persisting symptom data.
 * The concrete implementation will determine the destination (file, database, etc.)
 * and the writing format.
 *
 */

public interface ISymptomWriter {

// test comments
      public void WriteSymptoms();



}