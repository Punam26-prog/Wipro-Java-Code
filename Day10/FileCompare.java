package DayTen;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileCompare {
	public static void main(String[] args) {
        // Replace these paths with actual file paths on your system
        String file1Path = "E:\\P.txt";
        String file2Path = "E:\\Q.txt";

        try (BufferedReader reader1 = new BufferedReader(new FileReader(file1Path));
             BufferedReader reader2 = new BufferedReader(new FileReader(file2Path))) {

            String line1 = reader1.readLine();
            String line2 = reader2.readLine();
            boolean areEqual = true;
            int lineNum = 1;

            while (line1 != null || line2 != null) {
                if (line1 == null || line2 == null) {
                    areEqual = false;
                    break;
                } else if (!line1.equals(line2)) {
                    areEqual = false;
                    break;
                }

                line1 = reader1.readLine();
                line2 = reader2.readLine();
                lineNum++;
            }

            if (areEqual) {
                System.out.println("The two files have identical content.");
            } else {
                System.out.println("The two files differ at line " + lineNum);
                System.out.println("P : " + line1);
                System.out.println("Q : " + line2);
            }

        } catch (IOException e) {
            System.out.println("An error occurred while reading the files.");
            e.printStackTrace();
        }
    }
}


