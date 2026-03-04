import java.util.Scanner;


public class Menu {
    private Scanner scanner;
    private Calculator calculator;
    private BMICalculator bmiCalculator;
    private Validation validation;

    public Menu() {
        this.scanner = new Scanner(System.in);
        this.calculator = new Calculator();
        this.bmiCalculator = new BMICalculator();
        this.validation = new Validation();
    }

    public void displayMenu() {
        System.out.println("========= Calculator Program =========");
        System.out.println("1. Normal Calculator");
        System.out.println("2. BMI Calculator");
        System.out.println("3. Exit");
        System.out.print("Please choice one option: ");
    }


    public void run() {
        while (true) {
            displayMenu();
            String choice = scanner.nextLine();

            switch (choice.trim()) {
                case "1":
                    normalCalculator();
                    break;
                case "2":
                    bmiCalculatorMenu();
                    break;
                case "3":
                    System.out.println("Exiting program...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice! Please select 1, 2, or 3.");
            }
            System.out.println();
        }
    }


    private void normalCalculator() {
        System.out.println("----- Normal Calculator -----");

        // Get first number
        System.out.print("Enter number: ");
        String input = scanner.nextLine();
        Double memory = validation.checkIn(input);

        if (memory == null) {
            System.out.println("Invalid number input!");
            return;
        }

        while (true) {
            // Get operator
            System.out.print("Enter Operator: ");
            String operatorStr = scanner.nextLine();
            Operator operator = validation.checkOperator(operatorStr);

            if (operator == null) {
                System.out.println("Please input (+, -, *, /, ^)");
                continue;
            }

            // Check if equals sign
            if (operator == Operator.EQUAL) {
                System.out.println("Result:" + memory);
                break;
            }

            // Display current memory
            System.out.println("Memory:" + memory);

            // Get next number
            System.out.print("Enter number: ");
            input = scanner.nextLine();
            Double number = validation.checkIn(input);

            if (number == null) {
                System.out.println("Invalid number input!");
                continue;
            }

            // Perform calculation
            try {
                if (operator == Operator.DIVIDE && number == 0) {
                    System.out.println("Cannot divide by zero!");
                    continue;
                }
                memory = calculator.calculate(memory, operator, number);
            } catch (ArithmeticException e) {
                System.out.println("Error: " + e.getMessage());
                continue;
            } catch (Exception e) {
                System.out.println("Calculation error: " + e.getMessage());
                continue;
            }
        }
    }


    private void bmiCalculatorMenu() {
        System.out.println("----- BMI Calculator -----");

        // Get weight
        Double weight = null;
        while (weight == null) {
            System.out.print("Enter Weight(kg): ");
            String input = scanner.nextLine();
            weight = validation.checkIn(input);

            if (weight == null) {
                System.out.println("BMI is digit");
            } else if (!validation.isPositive(weight)) {
                System.out.println("Weight must be positive!");
                weight = null;
            }
        }

        // Get height
        Double height = null;
        while (height == null) {
            System.out.print("Enter Height(cm): ");
            String input = scanner.nextLine();
            height = validation.checkIn(input);

            if (height == null) {
                System.out.println("BMI is digit");
            } else if (!validation.isPositive(height)) {
                System.out.println("Height must be positive!");
                height = null;
            }
        }

        // Calculate BMI
        try {
            double bmiValue = bmiCalculator.calculateBMIValue(weight, height);
            BMIStatus status = bmiCalculator.calculateBMI(weight, height);

            System.out.printf("BMI Number: %.2f%n", bmiValue);
            System.out.println("BMI Status: " + status.getDescription());
        } catch (Exception e) {
            System.out.println("Error calculating BMI: " + e.getMessage());
        }
    }
}

