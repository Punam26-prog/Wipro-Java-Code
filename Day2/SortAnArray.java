package Operators;

import java.util.Arrays;

//PROGRAM TO SORT AN ARRAY

public class SortAnArray {

	public static void main(String[] args) {
		int[] arr = {50,20,40,62,12,85};
		Arrays.sort(arr);
		
		System.out.println("Sorted Array: ");
		
		for(int value : arr) {
			System.out.print(value + " ");
		}
		
		
		// TODO Auto-generated method stub

	}

}
