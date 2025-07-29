package newPackage;
import java.util.Scanner;

public class AtmProject {
	private double balance;
	
    private Scanner scanner;

    // Constructor
    public AtmProject ()  {
        balance = 1000.0; // initial balance $1000
        scanner = new Scanner(System.in);
    }

    // Display Menu
    public void displayMenu() {
        System.out.println("\nATM Menu");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. Exit");
        
    }

    // Check Balance
    public void checkBalance() {
        System.out.printf("Your Balance is $" +balance);
    }

    // Deposit Money
    public void depositMoney() {
        System.out.print("Enter amount to deposit: $");
        double amount = scanner.nextDouble();
        if (amount > 0) {
            balance += amount;
            System.out.printf("$" +amount + "has been deposited.");
        } else {
            System.out.println("Invalid deposit amount please add positive value.");
        }
    }

    // Withdraw Money
    public void withdrawMoney() {
        System.out.print("Enter amount to withdraw: $");
        double amount = scanner.nextDouble();
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.printf("$" +amount, "has been withdrawn");
        } else if (amount > balance) {
            System.out.println("Insufficient funds.Your balance is $" +balance);
        } else {
            System.out.println("Invalid withdrawal amount,please enter a positive value");
        }
    }


    // Main method
    public static void main(String[] args) {
        AtmProject atm = new AtmProject();
        while(true)
        {
        	atm.displayMenu();
        	System.out.println("Enter your choice");
        	int choice=atm.scanner.nextInt();
        	
        	switch(choice) {
        	case 1:
        		atm.checkBalance();
        		break;
        	case 2:
        		atm.depositMoney();
        		break;
        	case 3:
        		atm.withdrawMoney();
        		break;
        	case 4:
        		System.out.println("Thankyou for using ATM,Good Bye");
        	default:
        		System.out.println("Invalid choice,please select a valid option");
        	}
        }
    }
	

}
