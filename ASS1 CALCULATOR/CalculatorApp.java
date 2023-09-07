import java.util.*;

// creating calculator interface
interface Calc {
    double add(double num1, double num2);
    double subtract(double num1, double num2);
    double multiply(double num1, double num2);
    double divide(double num1, double num2);
    double squareRoot(double num);
    double power(double base, double exponent);
    double logarithm(double num);
}

// Calculator class implementing Calc interface
class Calculator implements Calc {
    @Override
    public double add(double num1, double num2) {
        return num1 + num2;
    }
    @Override
    public double subtract(double num1, double num2) {
        return num1 - num2;
    }
    @Override
    public double multiply(double num1, double num2) {
        return num1 * num2;
    }
    @Override
    public double divide(double num1, double num2) {
        if (num2 == 0) {
            throw new ArithmeticException("Division by zero is not allowed.");
        }
        return num1 / num2;
    }
    @Override
    public double squareRoot(double num) {
        if (num < 0) {
            throw new ArithmeticException("Square root of a negative number is not defined.");
        }
        return Math.sqrt(num);
    }
    @Override
    public double power(double base, double exponent) {
        return Math.pow(base, exponent);
    }
    @Override
    public double logarithm(double num) {
        if (num <= 0) {
            throw new ArithmeticException("Logarithm of a non-positive number is not defined.");
        }
        return Math.log(num);
    }
}

public class CalculatorApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calculator calculator = new Calculator();
        Stack<Double> history = new Stack<>();

        while (true) {
            System.out.println("Select operation:");
            System.out.println("1. Add");
            System.out.println("2. Subtract");
            System.out.println("3. Multiply");
            System.out.println("4. Divide");
            System.out.println("5. Square Root");
            System.out.println("6. Power");
            System.out.println("7. Logarithm");
            System.out.println("8. Recall Previous Result");
            System.out.println("9. Clear History");
            System.out.println("10. Exit");

            int choice = sc.nextInt();

            if (choice == 10) {
                System.out.println("Exiting the calculator.");
                break;
            }

            double result = 0;

            switch (choice) {
                case 1:
                    System.out.print("Enter first number: ");
                    double num1 = sc.nextDouble();
                    System.out.print("Enter second number: ");
                    double num2 = sc.nextDouble();
                    result = calculator.add(num1, num2);
                    break;
                case 2:
                    System.out.print("Enter first number: ");
                    num1 = sc.nextDouble();
                    System.out.print("Enter second number: ");
                    num2 = sc.nextDouble();
                    result = calculator.subtract(num1, num2);
                    break;
                case 3:
                    System.out.print("Enter first number: ");
                    num1 = sc.nextDouble();
                    System.out.print("Enter second number: ");
                    num2 = sc.nextDouble();
                    result = calculator.multiply(num1, num2);
                    break;
                case 4:
                    System.out.print("Enter first number: ");
                    num1 = sc.nextDouble();
                    System.out.print("Enter second number: ");
                    num2 = sc.nextDouble();
                    try {
                        result = calculator.divide(num1, num2);
                    } catch (ArithmeticException e) {
                        System.out.println("Error: " + e.getMessage());
                        continue; // Skip the calculation and show the menu again
                    }
                    break;
                case 5:
                    System.out.print("Enter a number: ");
                    num1 = sc.nextDouble();
                    result = calculator.squareRoot(num1);
                    break;
                case 6:
                    System.out.print("Enter the base: ");
                    num1 = sc.nextDouble();
                    System.out.print("Enter the exponent: ");
                    num2 = sc.nextDouble();
                    result = calculator.power(num1, num2);
                    break;
                case 7:
                    System.out.print("Enter a number: ");
                    num1 = sc.nextDouble();
                    result = calculator.logarithm(num1);
                    break;
                case 8:
                    if (!history.isEmpty()) {
                        result = history.peek();
                        System.out.println("Previous result: " + result);
                    } else {
                        System.out.println("No previous result available.");
                    }
                    break;
                case 9:
                    history.clear();
                    System.out.println("History cleared.");
                    break;
                default:
                    System.out.println("Invalid choice.");
                    continue; // Show the menu again
            }

            history.push(result);
            System.out.println("Result: " + result);
        }
    }
}
