import java.util.Scanner;


public class Validate {
    private static final Scanner scanner = new Scanner(System.in);

    public static int getBaseChoice(String type) {
        while (true) {
            System.out.println("\nChoose " + type + " base:");
            System.out.println("1. Binary (Base 2)");
            System.out.println("2. Decimal (Base 10)");
            System.out.println("3. Hexadecimal (Base 16)");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    return 2;
                case "2":
                    return 10;
                case "3":
                    return 16;
                case "0":
                    return -1;
                default:
                    System.out.println("Invalid choice! Please enter 1, 2, 3, or 0.");
            }
        }
    }


    public static String getInputValue(int base) {
        while (true) {
            System.out.print("\nEnter the " + getBaseName(base) + " value (or 'exit' to quit): ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("exit")) {
                return null;
            }

            if (input.isEmpty()) {
                System.out.println("Error: Input cannot be empty!");
                continue;
            }

            // Kiểm tra tính hợp lệ của input theo base
            if (isValidInput(input, base)) {
                return input.toUpperCase();
            } else {
                System.out.println("Error: Invalid " + getBaseName(base) + " value! Please try again.");
                printValidCharacters(base);
            }
        }
    }


    private static boolean isValidInput(String input, int base) {
        if (input.isEmpty()) {
            return false;
        }

        // Xác định tập ký tự hợp lệ theo từng hệ cơ số
        String validChars;
        switch (base) {
            case 2:
                validChars = "01";
                break;
            case 10:
                validChars = "0123456789";
                break;
            case 16:
                validChars = "0123456789ABCDEFabcdef";
                break;
            default:
                return false;
        }

        // Duyệt qua từng ký tự để kiểm tra
        for (char c : input.toCharArray()) {
            if (validChars.indexOf(c) == -1) {
                return false;
            }
        }

        return true;
    }


    private static void printValidCharacters(int base) {
        switch (base) {
            case 2:
                System.out.println("Valid characters for binary: 0, 1");
                break;
            case 10:
                System.out.println("Valid characters for decimal: 0-9");
                break;
            case 16:
                System.out.println("Valid characters for hexadecimal: 0-9, A-F");
                break;
        }
    }

    private static String getBaseName(int base) {
        switch (base) {
            case 2:
                return "Binary";
            case 10:
                return "Decimal";
            case 16:
                return "Hexadecimal";
            default:
                return "Unknown";
        }
    }


    public static void closeScanner() {
        scanner.close();
    }
}

