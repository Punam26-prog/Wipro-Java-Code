package DayTen;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BufferReaderDemo {
    public static void main(String[] args) throws IOException {
        System.out.println("Enter a number: ");
        
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);

        int a = Integer.parseInt(br.readLine());

        System.out.println("You entered: " + a);

        br.close();
    }
}