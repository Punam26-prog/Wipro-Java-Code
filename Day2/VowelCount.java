package Operators;

public class VowelCount {

	public static void main(String[] args) {
		
		String str = "Java programming";
		int count = 0;
		
		str = str.toLowerCase();
		
		for(int i=0; i<str.length(); i++) {
			char ch = str.charAt(i);
			
			if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'e' || ch=='o' || ch =='u') {
				count ++;
				
			}
		}
		System.out.println("No. of vowels in  this sentence: " + count);
		
		// TODO Auto-generated method stub

	}

}
