package DayTwelve;

import java.io.FileWriter;
import java.io.IOException;

public class File_Writer1 {
	public static void main(String[] args) throws IOException {
    String content = "This is a text write file of Punam:";

    FileWriter writer = new FileWriter("E:\\book.txt");
    writer.write(content);
    writer.close();  // Always close the writer
    
    System.out.println("File written successfully!");
}

}
