package dayThree;

public class Calculator {
	class Calculator1{
		public int add(int a, int b) {
			return a+b;
		}
		public double add(double a, double b) {
			return a+b;
		}
		
	}
	public static void main(String[] args) {
		Calculator c= new Calculator();
		Calculator1 c1 = c.new Calculator1();
		System.out.println("integers:" +  c1.add(2,3));
		System.out.println("numbers:" + c1.add(1.1, 2.34));

	}

}
