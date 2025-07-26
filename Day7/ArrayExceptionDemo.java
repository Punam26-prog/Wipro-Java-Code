package Dayseven;

public class ArrayExceptionDemo {
	public static void main(String[] args) {
        int[] numbers = {10, 20, 30, 40, 50}; 

        try {
            
            System.out.println("Accessing 6th element: " + numbers[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
           
            System.out.println("Exception caught: " + e);
        } finally {
            
            System.out.println("Finally block executed.");
        }

        System.out.println("Program continues...");
    }

}
