package Dayseven;
import java.util.Scanner;
// FACTORAL PROGRAM USING USE CATCH BLOCK AND FINALLY
public class FactorialWithTryCatchFinally {
	public static void main (String[] args) {
		Scanner scanner = new Scanner(System.in);

        try {
            // Take input from the user
            System.out.print("Enter a non-negative integer: ");
            int number = scanner.nextInt();

            // Check for negative input
            if (number < 0) {
                throw new IllegalArgumentException("Factorial is not defined for negative numbers.");
            }

            // Calculate factorial
            long factorial = 1;
            for (int i = 1; i <= number; i++) {
                factorial *= i;
            }

            System.out.println("Factorial of " + number + " is: " + factorial);
        } 
        catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } 
        catch (Exception e) {
            System.out.println("Invalid input. Please enter an integer.");
        } 
        finally {
            // This block always executes
            System.out.println("Program has ended.");
            scanner.close();
        }
	}

}
