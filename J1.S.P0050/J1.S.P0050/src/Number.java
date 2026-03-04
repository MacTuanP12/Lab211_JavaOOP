import java.util.Scanner;

/**
 * Number utility class for validation and number checking
 */
public class Number {
    private Scanner scanner;

    /**
     * Constructor
     */
    public Number(Scanner scanner) {
        this.scanner = scanner;
    }

    /**
     * Check if input string is a valid float number
     * @param floatString the string to check
     * @return Float value if valid, null otherwise
     */
    public Float checkin(String floatString) {
        try {
            return Float.parseFloat(floatString);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public boolean isOdd(float number) {
        // Only check for integers
        if (number != (int) number) {
            return false;
        }
        return ((int) number) % 2 != 0;
    }


    public boolean isEven(float number) {
        // Only check for integers
        if (number != (int) number) {
            return false;
        }
        return ((int) number) % 2 == 0;
    }


    public boolean isPerfectSquare(float number) {
        if (number < 0) {
            return false;
        }
        double sqrt = Math.sqrt(number);
        return sqrt == Math.floor(sqrt);
    }


    public float inputFloat(String prompt) {
        Float value = null;
        while (value == null) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            value = checkin(input);
            if (value == null) {
                System.out.println("Please input number");
            }
        }
        return value;
    }
}

