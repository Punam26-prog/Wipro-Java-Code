package Operators;

// PROGRAM  TO REVERSE AN ARRAY

public class ReverseAnArray {

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7,8,9};
		System.out.println("Reverse an Array:");
		for(int i=arr.length-1; i>=0; i--){
			System.out.print(arr[i] + " ");
		}

	}

}
