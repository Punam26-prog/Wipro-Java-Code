package DayTwelve;

import java.util.Scanner;

public class PalindromeCheck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner scanner = new Scanner(System.in);

	        System.out.print("Enter a string: ");
	        String input = scanner.nextLine();

	        String str = input.replaceAll("\\s+", "").toLowerCase();

	        String reversed = "";
	        for (int i = str.length() - 1; i >= 0; i--) {
	            reversed += str.charAt(i);
	        }
	        if (str.equals(reversed)) {
	            System.out.println("The string is a palindrome.");
	        } else {
	            System.out.println("The string is not a palindrome.");
	        }

	        scanner.close();
	}

}
