import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Manager {
    private Number numberUtil;

    public Manager(Scanner scanner) {
        this.numberUtil = new Number(scanner);
    }


    public List<Float> calculateEquation(float a, float b) {
        List<Float> solutions = new ArrayList<>();

        if (a == 0) {
            if (b == 0) {
                // 0x + 0 = 0 => infinitely many solutions
                return solutions; // empty list
            } else {
                // 0x + b = 0 (b != 0) => no solution
                return null;
            }
        } else {
            // ax + b = 0 => x = -b/a
            float x = -b / a;
            solutions.add(x);
            return solutions;
        }
    }


    public List<Float> calculateQuadraticEquation(float a, float b, float c) {
        List<Float> solutions = new ArrayList<>();

        if (a == 0) {
            // Not a quadratic equation, becomes linear: bx + c = 0
            return calculateEquation(b, c);
        }

        // Calculate discriminant: delta = b^2 - 4ac
        float delta = b * b - 4 * a * c;

        if (delta < 0) {
            // No real solution
            return null;
        } else if (delta == 0) {
            // One solution: x = -b / 2a
            float x = -b / (2 * a);
            solutions.add(x);
        } else {
            // Two solutions
            float x1 = (float) ((-b + Math.sqrt(delta)) / (2 * a));
            float x2 = (float) ((-b - Math.sqrt(delta)) / (2 * a));
            solutions.add(x1);
            solutions.add(x2);
        }

        return solutions;
    }

    public void displaySolutions(List<Float> solutions) {
        if (solutions == null) {
            System.out.println("No solution!");
        } else if (solutions.isEmpty()) {
            System.out.println("Infinitely many solutions!");
        } else {
            System.out.println("Solution(s):");
            for (int i = 0; i < solutions.size(); i++) {
                System.out.printf("x%d = %.2f%n", (i == 0 ? (solutions.size() == 1 ? 0 : 1) : 2), solutions.get(i));
            }
        }
    }

    public void analyzeNumbers(float... numbers) {
        List<Float> oddNumbers = new ArrayList<>();
        List<Float> evenNumbers = new ArrayList<>();
        List<Float> perfectSquares = new ArrayList<>();

        for (float num : numbers) {
            // Check odd
            if (numberUtil.isOdd(num)) {
                oddNumbers.add(num);
            }
            // Check even
            if (numberUtil.isEven(num)) {
                evenNumbers.add(num);
            }
            // Check perfect square
            if (numberUtil.isPerfectSquare(num)) {
                perfectSquares.add(num);
            }
        }

        // Display results
        if (!oddNumbers.isEmpty()) {
            System.out.print("Number is Odd:");
            for (int i = 0; i < oddNumbers.size(); i++) {
                System.out.print(oddNumbers.get(i));
                if (i < oddNumbers.size() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }

        if (!evenNumbers.isEmpty()) {
            System.out.print("Number is Even:");
            for (int i = 0; i < evenNumbers.size(); i++) {
                System.out.print(evenNumbers.get(i));
                if (i < evenNumbers.size() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }

        if (!perfectSquares.isEmpty()) {
            System.out.print("Number is Perfect Square:");
            for (int i = 0; i < perfectSquares.size(); i++) {
                System.out.print(perfectSquares.get(i));
                if (i < perfectSquares.size() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }
    }
}
