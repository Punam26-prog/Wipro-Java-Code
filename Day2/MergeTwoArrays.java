package Operators;

// PROFRAM TWO MERGE TWO ARRAYS

public class MergeTwoArrays {

	public static void main(String[] args) {
		
		int[]  a= {12,3,85};
		int[] b= {45,78};
		
		int[] c = new int[a.length + b.length];
		
		
		for(int i=0; i<a.length;i++) {
			c[i] = a[i];
			
		}
		for(int i=0; i<b.length; i++) {
			c[a.length + i] = b[i];
		
			
		}
		System.out.println("Merger two arrays:");
		for(int value : c) {
			System.out.print(value + " ");
		}
			

	}

}
