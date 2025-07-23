package Operators;

public class LargestofThree {

	public static void main(String[] args) {
		
		int a=10; int b = 20; int c = 90;
		
		if(a >= b && a >= c) {
			System.out.println("Largest number is:" + a);
			
		}else  if(b >= c && b >= c){
			System.out.println("Largest number is" + b);
			
		}else {
			System.out.println("Largest number is " + c);
		}

	}

}
