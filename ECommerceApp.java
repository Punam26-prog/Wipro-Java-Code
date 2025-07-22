package dayThree;

public class ECommerceApp {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PaymentMode payment;

        payment = new UpiPayment();
        payment.pay(1500.00);

        payment = new CreditCardPayment();
        payment.pay(3200.00);

        payment = new CashOnDelivery();
        payment.pay(2000.00);
    }
	

}
