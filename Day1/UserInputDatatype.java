package newPackage;
import java.util.Scanner;

public class UserInputDatatype {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = sc.nextLine();
        System.out.print("Enter your score (int): ");
        int score = sc.nextInt();
        System.out.print("Enter your height (double): ");
        double height = sc.nextDouble();
        System.out.println("\nHello, " + name);
        System.out.println("Score: " + score);
        System.out.println("Height: " + height);
		

	}

}
