import java.util.Random;
import java.util.Scanner;


public class Main {

    /**
     * Hàm nhập số lượng phần tử của mảng từ người dùng
     * Function to input the size of array from user
     *
     * @param scanner Scanner object để đọc input
     * @return Số lượng phần tử hợp lệ (số nguyên dương)
     */
    public static int inputArraySize(Scanner scanner) {
        int size = 0;
        boolean isValid = false;

        while (!isValid) {
            try {
                System.out.print("Enter the number of array: ");
                String input = scanner.nextLine().trim();

                // Kiểm tra input có phải số thực dương không
                // Check if input is a positive decimal number
                double temp = Double.parseDouble(input);

                if (temp <= 0) {
                    System.out.println("Error! Please enter a positive number.");
                    continue;
                }

                // Chuyển thành số nguyên để tạo mảng
                // Convert to integer for array size
                size = (int) temp;

                if (size != temp) {
                    System.out.println("Warning: Decimal value entered. Using integer part: " + size);
                }

                isValid = true;

            } catch (NumberFormatException e) {
                System.out.println("Error! Invalid input. Please enter a valid positive number.");
            }
        }

        return size;
    }

    /**
     * Hàm tạo mảng ngẫu nhiên
     * Function to generate random array
     *
     * @param size Kích thước của mảng
     * @return Mảng chứa các số nguyên ngẫu nhiên
     *
     * Ví dụ: size = 5
     * Kết quả có thể là: [23, 7, 45, 12, 89]
     */
    public static int[] generateRandomArray(int size) {
        int[] array = new int[size];
        Random random = new Random();

        // Tạo các số ngẫu nhiên từ 0 đến 99
        // Generate random numbers from 0 to 99
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(100);
        }

        return array;
    }

    /**
     * Hàm hiển thị mảng
     * Function to display array
     *
     * @param array Mảng cần hiển thị
     * @param message Thông điệp mô tả (ví dụ: "Unsorted array", "Sorted array")
     *
     * Ví dụ đầu ra:
     * [12, 5, 23, 8, 45, 1]
     */
    public static void displayArray(int[] array, String message) {
        System.out.println(message);
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    /**
     * Thuật toán Insertion Sort - Sắp xếp chèn
     * Insertion Sort Algorithm
     *
     * Nguyên lý:
     * - Chia mảng thành 2 phần: phần đã sắp xếp (bên trái) và phần chưa sắp xếp (bên phải)
     * - Ban đầu, phần đã sắp xếp chỉ có 1 phần tử đầu tiên
     * - Lần lượt lấy từng phần tử từ phần chưa sắp xếp và chèn vào đúng vị trí trong phần đã sắp xếp
     * - Quá trình dừng khi phần chưa sắp xếp trở nên rỗng
     *
     * Độ phức tạp:
     * - Trường hợp tốt nhất: O(n) - khi mảng đã được sắp xếp
     * - Trường hợp trung bình: O(n²)
     * - Trường hợp xấu nhất: O(n²) - khi mảng được sắp xếp ngược
     *
     * @param array Mảng cần sắp xếp
     *
     * Ví dụ chi tiết:
     * Mảng ban đầu: [64, 25, 12, 22, 11]
     *
     * Lần lặp 1 (i=1): key = 25
     *   [64 | 25, 12, 22, 11] - Phần đã sắp xếp: [64]
     *   So sánh 25 < 64? Có -> Dịch 64 sang phải
     *   Chèn 25 vào vị trí 0
     *   Kết quả: [25, 64, 12, 22, 11]
     *
     * Lần lặp 2 (i=2): key = 12
     *   [25, 64 | 12, 22, 11]
     *   So sánh 12 < 64? Có -> Dịch 64 sang phải
     *   So sánh 12 < 25? Có -> Dịch 25 sang phải
     *   Chèn 12 vào vị trí 0
     *   Kết quả: [12, 25, 64, 22, 11]
     *
     * Lần lặp 3 (i=3): key = 22
     *   [12, 25, 64 | 22, 11]
     *   So sánh 22 < 64? Có -> Dịch 64 sang phải
     *   So sánh 22 < 25? Có -> Dịch 25 sang phải
     *   So sánh 22 < 12? Không -> Dừng
     *   Chèn 22 vào vị trí 1
     *   Kết quả: [12, 22, 25, 64, 11]
     *
     * Lần lặp 4 (i=4): key = 11
     *   [12, 22, 25, 64 | 11]
     *   So sánh 11 < 64? Có -> Dịch 64 sang phải
     *   So sánh 11 < 25? Có -> Dịch 25 sang phải
     *   So sánh 11 < 22? Có -> Dịch 22 sang phải
     *   So sánh 11 < 12? Có -> Dịch 12 sang phải
     *   Chèn 11 vào vị trí 0
     *   Kết quả: [11, 12, 22, 25, 64]
     *
     * Mảng sau khi sắp xếp: [11, 12, 22, 25, 64]
     */
    public static void insertionSort(int[] array) {
        int n = array.length;

        // Bắt đầu từ phần tử thứ 2 (index = 1) vì phần tử đầu tiên đã được coi là đã sắp xếp
        for (int i = 1; i < n; i++) {
            // key là phần tử hiện tại cần chèn vào phần đã sắp xếp
            int key = array[i];
            int j = i - 1;

            // Di chuyển các phần tử của phần đã sắp xếp (từ 0 đến i-1)
            // mà lớn hơn key sang phải một vị trí
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];  // Dịch phần tử sang phải
                j = j - 1;
            }

            // Chèn key vào vị trí đúng
            array[j + 1] = key;

            // In ra trạng thái mảng sau mỗi bước (tùy chọn - có thể bỏ comment để xem chi tiết)
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // In tiêu đề chương trình
        // Print program title
        System.out.println("========================================");
        System.out.println("   INSERTION SORT ALGORITHM PROGRAM");
        System.out.println("========================================");
        System.out.println();

        // Bước 1: Nhập số lượng phần tử từ người dùng

        int size = inputArraySize(scanner);
        System.out.println("Array size confirmed: " + size);
        System.out.println();

        // Bước 2: Tạo mảng ngẫu nhiên
        int[] array = generateRandomArray(size);

        // Bước 3: Hiển thị mảng trước khi sắp xếp
        displayArray(array, "Unsorted array (Mang chua sap xep):");
        System.out.println();

        // Bước 4: Sắp xếp mảng bằng Insertion Sort
        System.out.println("Sorting... (Dang sap xep...)");
        insertionSort(array);
        System.out.println();

        // Bước 5: Hiển thị mảng sau khi sắp xếp
        displayArray(array, "Sorted array (Mang da sap xep):");
        System.out.println();

        System.out.println("========================================");
        System.out.println("   SORTING COMPLETED!");
        System.out.println("========================================");

        scanner.close();
    }
}