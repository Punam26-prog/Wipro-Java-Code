package dayThree;

public class SaleSystemOops2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SaleItem[] items = {
		           new SaleItem("Laptop", 50000, 1),
		           new SaleItem("Mouse", 500, 2),
		           new SaleItem("Keyboard", 1000, 1)
		       };
		       double grandTotal = 0;
		       System.out.println("Product\tPrice\tQty\tTotal");
		       System.out.println("--------------------------------------");
		       for (SaleItem item : items) {
		           item.displayItem();
		           grandTotal += item.getTotalprice();
		       }
		       System.out.println("--------------------------------------");
		       System.out.println("Grand Total: " + grandTotal);
		   }
}	
		
