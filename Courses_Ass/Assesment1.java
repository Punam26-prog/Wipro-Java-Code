package newPackage;

public class Assesment1 {
	public static void main(String[] args) {

        // Implicit Type Casting (Widening Conversion)
        int intValue = 10;
        double doubleValue = intValue; // int is implicitly cast to double

        System.out.println("Implicit Type Casting (Widening Conversion):");
        System.out.println("int: " + intValue);
        System.out.println("double: " + doubleValue);

        // Explicit Type Casting (Narrowing Conversion)
        double anotherDoubleValue = 15.75; // fixed variable name
        int anotherIntValue = (int) anotherDoubleValue; // cast double to int

        System.out.println("\nExplicit Type Casting (Narrowing Conversion):");
        System.out.println("double: " + anotherDoubleValue);
        System.out.println("int: " + anotherIntValue);
	}

}
