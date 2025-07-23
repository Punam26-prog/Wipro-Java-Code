package Operators;

// PROGRAM TO CALCULATE SUM OF ARRAY ELEMENTS

public class SumArray {
	
	public static void main(String[] args ) {
		int[] arr = {5, 10, 15, 20};
		int sum = 0;
		
		for (int value : arr) {
			sum += value;
			
		}
		System.out.println("Sum: " + sum);
	}

}
