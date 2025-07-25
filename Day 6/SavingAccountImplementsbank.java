package Daysix;

public class SavingAccountImplementsbank implements Bank {
	
	private double balance;

    // Constructor
    public SavingAccountImplementsbank(double initialBalance) {
        this.balance = initialBalance;
    }

   
    public double getBalance() {
        return balance;
    }

   
    public void deposit(double amount) {
        balance += amount;
    }

   
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
        } else {
            System.out.println("Insufficient funds to withdraw $" + amount);
        }
}
   
    public void displayAccountType() {
        System.out.println("Account Type: Savings Account");
    }
}
    



