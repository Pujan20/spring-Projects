package com.example.CreateFile;
import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
public class CReateFile {
	

	    public static void main(String[] args) {
	        // Number of data entries
	        int numEntries = 5000;

	        // CSV file name
	        String csvFileName = "data.csv";

	        try (CSVWriter writer = new CSVWriter(new FileWriter(csvFileName))) {
	            // Define the CSV header
	            String[] header = {"ID", "Name", "Age", "City"};
	            writer.writeNext(header);

	            // Generate and write random data entries
	            for (int i = 1; i <= numEntries; i++) {
	                String[] dataEntry = {
	                    String.valueOf(i),
	                    generateRandomName(),
	                    String.valueOf(generateRandomAge(18, 60)),
	                    generateRandomCity()
	                };
	                writer.writeNext(dataEntry);
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        System.out.println(numEntries + " data entries have been written to " + csvFileName);
	    }

	    // Generate random names
	    private static String generateRandomName() {
	        String[] names = {"Alice", "Bob", "Charlie", "David", "Eve", "Frank", "Grace", "Helen", "Ivy", "Jack"};
	        return names[new Random().nextInt(names.length)];
	    }

	    // Generate a random age within a specified range
	    private static int generateRandomAge(int min, int max) {
	        return new Random().nextInt(max - min + 1) + min;
	    }

	    // Generate random city names
	    private static String generateRandomCity() {
	        String[] cities = {"New York", "Los Angeles", "Chicago", "Houston", "Miami", "San Francisco"};
	        return cities[new Random().nextInt(cities.length)];
	    }

}
