package newPackage;
import java.util.Scanner;

public class Assessment2 {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);  // Create Scanner object

        System.out.print("Enter a number: ");
        int number = scanner.nextInt();  // Read the input

        if (number % 2 == 0) {
            System.out.println(number + " is an even number.");
        } else {
            System.out.println(number + " is an odd number.");
        }

        scanner.close();  // Close the scanner
    }

}
