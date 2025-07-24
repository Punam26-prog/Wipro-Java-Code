package DayFive;

public class TypeCastingExample {
	public static void  main(String[] args) {
		int intvalue = 10;
		double doubleValue = 99.99;
		float floatValue = (float) intvalue;
		int intFromDouble = (int) doubleValue;
		System.out.println("int value:" + intvalue);
		System.out.println("float value after conversion" + floatValue);
		System.out.println("double value after conversion" + doubleValue);
		System.out.println("int value after conversion from double" + intFromDouble);
		
	}

}
