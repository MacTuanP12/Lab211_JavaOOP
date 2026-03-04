
public class Main {

    public static void main(String[] args) {
        // Vòng lặp chính của chương trình - chạy cho đến khi người dùng chọn thoát
        while (true) {
            System.out.println("\n===== Change Base Number System Program =====");

            // Bước 1: Chọn hệ cơ số đầu vào
            int inputBase = Validate.getBaseChoice("input");
            if (inputBase == -1) {
                System.out.println("Exiting program. Goodbye!");
                break;
            }

            // Bước 2: Chọn hệ cơ số đầu ra
            int outputBase = Validate.getBaseChoice("output");
            if (outputBase == -1) {
                System.out.println("Exiting program. Goodbye!");
                break;
            }

            // Bước 3: Nhập giá trị cần chuyển đổi
            String inputValue = Validate.getInputValue(inputBase);
            if (inputValue == null) {
                System.out.println("Exiting program. Goodbye!");
                break;
            }

            // Bước 4: Thực hiện chuyển đổi và hiển thị kết quả
            try {
                String result = Manager.convertBase(inputValue, inputBase, outputBase);
                System.out.println("\nResult: " + result);
                System.out.println("Conversion: " + inputValue + " (" + Manager.getBaseName(inputBase) +
                                 ") = " + result + " (" + Manager.getBaseName(outputBase) + ")");
            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid input value for the selected base system!");
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        Validate.closeScanner();
    }
}