package dayThree;

public class BankAccount {
	private String accountHolderName;
	private double balance;
	public BankAccount(String accountHolderName, double initial) {
		this.accountHolderName = accountHolderName;
		this.balance = balance;
		
	}
	public void deposit(double amount) {
		balance = balance + amount;
				System.out.println("New balance" + balance);
	}
	public void withdraw(double amount) {
		if(amount>balance) {
			System.out.println("insufficient Balance");
		}else {
			balance = amount;
			System.out.println(amount + "withdraw.Remaining Balnace" + balance);
		}
	}
	public void displayDetails() {
		System.out.println("Account Holder" + accountHolderName);
		System.out.println("Balance" + balance);
	}
	

}
