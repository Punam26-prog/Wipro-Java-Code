package DayFive;

interface Lambacalculator1 {
    double add(double a, double b);
}

public class LambdaCalculator {
    public static void main(String[] args) {
     // Lambda for addition
        Lambacalculator1 addition = (a, b) -> {
            System.out.println("Addition");
            double result = a + b;
            System.out.println("Result: " + result);
            return result;
        };

  // Lambda for subtraction
        Lambacalculator1 subtract = (a, b) -> a - b;

  // Input values
        double a = 10000.0, b = 20000.0;

   // Perform addition
        addition.add(a, b);

    // Perform subtraction and print
        System.out.println("Subtract: " + subtract.add(a, b));
    }
}