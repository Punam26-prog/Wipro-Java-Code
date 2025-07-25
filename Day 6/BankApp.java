package Daysix;

public class BankApp {
	public static void main(String[] args) {
        Bank account = new SavingAccountImplementsbank(1000);

        account.displayAccountType();                  // displays account type
        account.executeTransaction("deposit", 500);    // deposit
        account.executeTransaction("withdraw", 200);   // withdraw
        account.executeTransaction("withdraw", -50);   // invalid
        System.out.println("Final Balance: $" + account.getBalance());
    }

}
