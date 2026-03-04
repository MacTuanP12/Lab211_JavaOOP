import java.util.List;
import java.util.Scanner;


public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Manager manager = new Manager(scanner);
    private static final Number numberUtil = new Number(scanner);

    public static void main(String[] args) {
        boolean running = true;

        System.out.println("========== EQUATION SOLVER ==========");

        while (running) {
            displayMenu();
            int choice = getChoice();

            switch (choice) {
                case 1:
                    solveSuperlativeEquation();
                    break;
                case 2:
                    solveQuadraticEquation();
                    break;
                case 3:
                    System.out.println("Thank you for using the program. Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice! Please select 1, 2, or 3.");
            }
            System.out.println();
        }

        scanner.close();
    }

    /**
     * Display main menu
     */
    private static void displayMenu() {
        System.out.println("========= Equation Program =========");
        System.out.println("1. Calculate Superlative Equation");
        System.out.println("2. Calculate Quadratic Equation");
        System.out.println("3. Exit");
    }


    private static int getChoice() {
        System.out.print("Please choice one option: ");
        String input = scanner.nextLine().trim();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return -1;
        }
    }


    private static void solveSuperlativeEquation() {
        System.out.println("----- Calculate Equation -----");

        // Input coefficients
        float a = numberUtil.inputFloat("Enter A: ");
        float b = numberUtil.inputFloat("Enter B: ");

        // Calculate and display solution
        List<Float> solutions = manager.calculateEquation(a, b);
        System.out.print("Solution: ");
        if (solutions == null) {
            System.out.println("No solution!");
        } else if (solutions.isEmpty()) {
            System.out.println("Infinitely many solutions!");
        } else {
            System.out.printf("x = %.3f%n", solutions.get(0));
        }

        // Analyze numbers
        manager.analyzeNumbers(a, b);
    }


    private static void solveQuadraticEquation() {
        System.out.println("----- Calculate Quadratic Equation -----");

        // Input coefficients
        float a = numberUtil.inputFloat("Enter A: ");
        float b = numberUtil.inputFloat("Enter B: ");
        float c = numberUtil.inputFloat("Enter C: ");

        // Calculate and display solution
        List<Float> solutions = manager.calculateQuadraticEquation(a, b, c);
        System.out.print("Solution: ");
        if (solutions == null) {
            System.out.println("No solution!");
        } else if (solutions.isEmpty()) {
            System.out.println("Infinitely many solutions!");
        } else if (solutions.size() == 1) {
            System.out.printf("x1 = x2 = %.3f%n", solutions.get(0));
        } else {
            System.out.printf("x1 = %.3f and x2 = %.3f%n", solutions.get(0), solutions.get(1));
        }

        // Analyze numbers
        manager.analyzeNumbers(a, b, c);
    }
}