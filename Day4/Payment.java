package DayFour;

abstract class Payments {
	double amount;
	Payments(double amount) {
		this.amount=amount;
	}
	abstract void makePayment();
	void showSuccessMessage() {
		System.out.println("Payment successfully done" + amount);
	}
}
class CreditCardPayment extends Payments {
	CreditCardPayment(double amount) {
		super(amount);
	}
	void makePayment() {
		System.out.println("Credit card Payment is Done");
	}
	
}
class UpiPayment extends Payments {
	UpiPayment(double amount){
		super(amount);
	}
	void makePayment() {
		System.out.println("Upi payment is done");
	}
	
}
public class Payment{
	public static void main(String[] args) {
		Payments py = new CreditCardPayment(5201);
		py.makePayment();
		System.out.println("Credit card payment is completed");
		
		Payments py2 = new UpiPayment(7852);
		py2.makePayment();
		System.out.println("Upi Payments is completed");
		
	}
}
