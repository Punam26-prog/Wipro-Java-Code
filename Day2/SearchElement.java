package Operators;
// PROGRAM TOSEARCH AN ELEMENT IN ARRAY

public class SearchElement {

	public static void main(String[] args) {
		
		int[] arr= {10,20,30,40,50,60};
		int key = 80;
		boolean found = false;
		
		for(int i=0; i<arr.length; i++) {
			if(arr[i] == key) {
				
				System.out.println("Element found at index: " + i);
				found = true;
				break;
				
			}
		}
		if(!found) {
			System.out.println("Element not found at index");
		}
		// TODO Auto-generated method stub

	}

}
