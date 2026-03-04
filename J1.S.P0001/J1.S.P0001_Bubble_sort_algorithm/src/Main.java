import java.util.Random;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    /**
     * Kiểm tra và lấy nhập liệu số nguyên dương từ người dùng
     */
    private static int checkInputInt() {
        while (true) {
            try {
                System.out.print("Enter number of array: ");
                int input = Integer.parseInt(scanner.nextLine());
                if (input > 0) {
                    return input;
                } else {
                    System.out.println("Invalid input. Please enter a positive integer.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a positive integer.");
            }
        }
    }

    // Tạo mảng gồm các số nguyên ngẫu nhiên
    // Các số nguyên nằm trong khoảng từ -50 đến 49
    private static int[] generateRandomArray(int size) {
        int[] array = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(100) - 50;
        }
        return array;
    }


    // Hiển thị mảng với nhãn mô tả
    private static void displayArray(int[] array, String label) {
        System.out.print(label + ": ");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }


    /**
     * CƠ CHẾ THUẬT TOÁN BUBBLE SORT:
     * =============================
     * 1. So sánh từng cặp phần tử kề nhau từ đầu mảng
     * 2. Nếu chúng theo thứ tự ngược (trái > phải), hoán đổi chúng
     * 3. Sau mỗi lần duyệt, phần tử lớn nhất "nổi" lên cuối mảng
     * 4. Lặp lại quy trình cho đến khi không có hoán đổi nào (mảy đã sắp xếp)
     *
     * Độ phức tạp thời gian: O(n²)
     * Độ phức tạp không gian: O(1)
     * Ổn định: Có (giữ được thứ tự tương đối của các phần tử bằng nhau)
     * Thích ứng: Có (nhanh hơn với mảng gần như đã sắp xếp)
     */
    private static void bubbleSort(int[] array) {
        int n = array.length;
        boolean swapped;

        // Vòng lặp ngoài: Mỗi lần lặp đại diện cho một lần duyệt hoàn chỉnh mảng
        // Sau lần duyệt i, i phần tử lớn nhất đã ở vị trí cuối cùng
        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            // Vòng lặp trong: So sánh các cặp kề nhau và hoán đổi nếu cần
            // (n - 1 - i) giảm phạm vi so sánh vì các phần tử đã sắp xếp dịch về cuối
            for (int j = 0; j < n - 1 - i; j++) {
                // Bước 1: So sánh cặp phần tử kề nhau
                if (array[j] > array[j + 1]) {
                    // Bước 2: Nếu phần tử trái > phần tử phải, hoán đổi chúng
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;  // Đánh dấu là đã có hoán đổi
                }
            }

            // Bước 3: Sau mỗi lần duyệt, kiểm tra có hoán đổi nào xảy ra không
            // Nếu không có hoán đổi, mảng đã được sắp xếp - thoát sớm
            if (!swapped) {
                break;
            }
            // Nếu có hoán đổi, tiếp tục lần duyệt tiếp theo
        }
    }

    public static void main(String[] args) {
        System.out.println("===== Bubble Sort Algorithm =====");
        System.out.println();

        // Bước 1: Yêu cầu người dùng nhập số lượng phần tử mảng
        int arraySize = checkInputInt();

        // Bước 2: Tạo mảng gồm các số nguyên ngẫu nhiên
        int[] unsortedArray = generateRandomArray(arraySize);

        // Step 3: Display unsorted array
        displayArray(unsortedArray, "Unsorted array");

        // Step 4: Sort the array using bubble sort
        bubbleSort(unsortedArray);

        // Step 5: Display sorted array
        displayArray(unsortedArray, "Sorted array  ");

        System.out.println();
        System.out.println("===== Sorting Complete =====");

        scanner.close();
    }

}