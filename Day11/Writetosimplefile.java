package DayEleven;
import java.io.FileWriter;
import java.io.IOException;

public class Writetosimplefile {
   public static void main(String[] args) {
       try {
           FileWriter writer = new FileWriter("E:\\book.txt");
           writer.write("Hello, I am trying to find testing tools for the ITC project.\n");
           writer.write("Tools like automation and performance tools.\n");
           writer.close();
           System.out.println("Data written to file successfully");
       } catch (IOException e) {
           System.out.println("An error occurred while writing to the file.");
           e.printStackTrace();
       }
   }
}