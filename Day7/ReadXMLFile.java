package Dayseven;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

// TRYING TO FETCH FROM CONTENT FROM XML FILE

public class ReadXMLFile {
	public static void main(String[] args) {
		
	        File xmlFile = new File("E:\\paint.xml");

	        try (BufferedReader reader = new BufferedReader(new FileReader(xmlFile))) {
	            String line;
	            while ((line = reader.readLine()) != null) {
	                System.out.println("XML Line: " + line);
	            }
	        } catch (IOException e) {
	            System.out.println("Error reading XML: " + e.getMessage());
	        }
	    }  
}
