package Operators;

public class PalindromeCheck {

	public static void main(String[] args) {
		
		String original = "punam";
		StringBuilder sb = new StringBuilder(original);
		sb.reverse();
		if(original.equals(sb.toString())) {
			System.out.println(original + " is a plaimdrome number.");
		}else {
			System.out.println(original + " is not a plaimdrome number.");
		}
;		// TODO Auto-generated method stub

	}

}
