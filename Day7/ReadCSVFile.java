package Dayseven;

// TRY TO FETCH CONTENT FROM CSV FILE

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadCSVFile {
	
	 public static void main(String[] args) {
	        File csvFile = new File("E:\\draw.csv"); // your CSV file path

	        // Optional: print the full path being used
	        System.out.println("Reading file from: " + csvFile.getAbsolutePath());

	        BufferedReader br = null;

	        try {
	            br = new BufferedReader(new FileReader(csvFile));
	            String line;

	            while ((line = br.readLine()) != null) {
	                // Print each line (i.e., each row of the CSV)
	                System.out.println("CSV Row: " + line);
	            }
	        } catch (IOException e) {
	            System.out.println("Error occurred while reading the CSV file: " + e.getMessage());
	        } finally {
	            try {
	                if (br != null) {
	                    br.close();
	                }
	                System.out.println("Finished reading the file.");
	            } catch (IOException e) {
	                System.out.println("Error while closing the file: " + e.getMessage());
	            }
	        }
	    }

}
