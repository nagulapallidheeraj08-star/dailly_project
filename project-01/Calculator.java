import java.util.Scanner;

/**
 * Calculator — Java Basics
 *
 * Demonstrates: variables & data types, Scanner input, arithmetic operators,
 * methods, switch statements, and a while loop.
 */
public class Calculator {

    // ---- Methods: one per operation (java basics: methods, parameters, return) ----
    static double add(double a, double b)      { return a + b; }
    static double subtract(double a, double b) { return a - b; }
    static double multiply(double a, double b) { return a * b; }

    static double divide(double a, double b) {
        if (b == 0) {
            System.out.println("Error: cannot divide by zero.");
            return Double.NaN;        // "not a number" sentinel
        }
        return a / b;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;       // boolean — controls the loop

        System.out.println("=== Java Basics Calculator ===");

        while (running) {
            System.out.print("\nEnter first number: ");
            double a = scanner.nextDouble();

            System.out.print("Enter an operator (+ - * /): ");
            String op = scanner.next();

            System.out.print("Enter second number: ");
            double b = scanner.nextDouble();

            double result;
            // switch on the operator — a core control-flow basic
            switch (op) {
                case "+": result = add(a, b);      break;
                case "-": result = subtract(a, b); break;
                case "*": result = multiply(a, b); break;
                case "/": result = divide(a, b);   break;
                default:
                    System.out.println("Unknown operator: " + op);
                    continue;          // skip to next loop iteration
            }

            // Only print a valid result (NaN means divide-by-zero happened)
            if (!Double.isNaN(result)) {
                System.out.println("Result: " + a + " " + op + " " + b + " = " + result);
            }

            System.out.print("Calculate again? (y/n): ");
            String again = scanner.next();
            running = again.equalsIgnoreCase("y");
        }

        System.out.println("Goodbye!");
        scanner.close();
    }
}
