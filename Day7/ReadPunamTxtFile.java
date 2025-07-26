package Dayseven;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadPunamTxtFile {
	public static void main(String[] args) {
        // Pointing to punam.txt on E: drive
        File file = new File("E:\\punam.txt");

        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader(file));
            String line;

            while ((line = br.readLine()) != null) {
                System.out.println("File Content: " + line);
            }
        } catch (IOException e) {
            System.out.println("Error occurred while reading the file: " + e.getMessage());
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
                System.out.println("File read completed.");
            } catch (IOException e) {
                System.out.println("Error while closing the file: " + e.getMessage());
            }
        }
    }

}
