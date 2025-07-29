package Course2;

import java.util.Random;

public class Randow_Number_Ass1 {
	 public static void main(String[] args) {

	        long random10DigitNumber = generateTenDigitRandomNumber();

	        System.out.println("Random 10-Digit Number: " + random10DigitNumber);
	    }

	    public static long generateTenDigitRandomNumber() {
	        Random random = new Random();

	        long min = 1000000000L;     // 10^9 (smallest 10-digit number)
	        long max = 9999999999L;     // 10^10 - 1 (largest 10-digit number)

	        // Generate a random number within the specified range
	        long random10DigitNumber = min + (long)(random.nextDouble() * (max - min + 1));

	        return random10DigitNumber;
	    }
}
