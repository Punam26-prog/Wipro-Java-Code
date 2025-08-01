package DayTwelve;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferWriter {
	public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("E:\\book.txt", true));
        
        bw.write("This is written using FileWriter");
        bw.newLine(); // Optional: writes a new line
        bw.close();
        
        System.out.println("Written Successfully");
    }

}
