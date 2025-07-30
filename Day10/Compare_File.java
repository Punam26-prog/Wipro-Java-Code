package DayTen;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class FileComparator {
    private String file1Path;
    private String file2Path;

    public FileComparator(String file1Path, String file2Path) {
        this.file1Path = file1Path;
        this.file2Path = file2Path;
    }

    public void compareFiles() throws IOException {
        try (BufferedReader reader1 = new BufferedReader(new FileReader(file1Path));
             BufferedReader reader2 = new BufferedReader(new FileReader(file2Path))) {

            String line1, line2;
            int lineNum = 1;
            boolean areEqual = true;

            while ((line1 = reader1.readLine()) != null | (line2 = reader2.readLine()) != null) {
                if (line1 == null || line2 == null || !line1.equals(line2)) {
                    areEqual = false;
                    System.out.println("The two files differ at line " + lineNum);
                    System.out.println("File1: " + line1);
                    System.out.println("File2: " + line2);
                    break;
                }
                lineNum++;
            }

            if (areEqual) {
                System.out.println("The two files have identical content.");
            }
        }
    }
}

public class Compare_File {
	 public static void main(String[] args) throws IOException {
	        FileComparator comparator = new FileComparator("E:\\P.txt", "E:\\Q.txt");
	        comparator.compareFiles();
	    }

}
