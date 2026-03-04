import java.util.Scanner;
import java.util.Random;

public class Main {

    /*


    1. KHÁI NIỆM:
       Selection Sort là một thuật toán sắp xếp đơn giản dựa trên ý tưởng chia mảng
       thành hai phần:
       - Phần đã sắp xếp (sorted part): Chứa các phần tử đã được sắp xếp (bên trái)
       - Phần chưa sắp xếp (unsorted part): Chứa các phần tử cần sắp xếp (bên phải)

    2. NGUYÊN LÝ HOẠT ĐỘNG:
       Mỗi lần lặp, thuật toán sẽ:
       a) Tìm phần tử nhỏ nhất trong phần chưa sắp xếp
       b) Hoán đổi phần tử nhỏ nhất này với phần tử đầu tiên của phần chưa sắp xếp
       c) Di chuyển ranh giới: phần đã sắp xếp mở rộng thêm 1 phần tử
       d) Lặp lại cho đến khi phần chưa sắp xếp là rỗng

    3. VÍ DỤ MINH HỌA:
       Mảng ban đầu: [5, 1, 12, -5, 16, 2, 12, 14]

       Bước 1: Tìm min(-5) → Hoán đổi 5 và -5
               Kết quả: [-5 | 1, 12, 5, 16, 2, 12, 14]

       Bước 2: Tìm min(1) → Không hoán đổi (đã đúng vị trí)
               Kết quả: [-5, 1 | 12, 5, 16, 2, 12, 14]

       Bước 3: Tìm min(2) → Hoán đổi 12 và 2
               Kết quả: [-5, 1, 2 | 5, 16, 12, 12, 14]

       Tiếp tục cho đến khi phần chưa sắp xếp trống:
               Kết quả cuối: [-5, 1, 2, 5, 12, 12, 14, 16]

    4. ĐẶC ĐIỂM:
       - Độ phức tạp thời gian: O(n²) trong mọi trường hợp (tồi nhất, trung bình, tốt nhất)
       - Độ phức tạp không gian: O(1) - sắp xếp tại chỗ
       - Độ ổn định: KHÔNG ổn định (các phần tử bằng nhau có thể đảo vị trí)
       - Số lần so sánh: n(n-1)/2
       - Số lần hoán đổi: Tối đa n-1

    5. ƯU VÀ NHƯỢC ĐIỂM:
       ✓ Ưu điểm:
         - Dễ hiểu và dễ cài đặt
         - Sắp xếp tại chỗ (không cần thêm bộ nhớ)
         - Ít hoán đổi hơn Bubble Sort (tối đa n-1 hoán đổi)

       ✗ Nhược điểm:
         - Hiệu suất kém với dữ liệu lớn (O(n²))
         - Không ổn định - thứ tự các phần tử bằng nhau có thể thay đổi
         - Không phù hợp với danh sách liên kết (truy cập ngẫu nhiên chậm)

    6. KHI NÀO DÙNG:
       - Dữ liệu nhỏ (n < 100)
       - Bộ nhớ bị giới hạn (vì sắp xếp tại chỗ)
       - Khi muốn giảm số lần hoán đổi
    ════════════════════════════════════════════════════════════════════════════════
    */

    // Hàm thực hiện sắp xếp Selection Sort
    // Ý tưởng: Chia mảy thành 2 phần - phần đã sắp xếp (trái) và chưa sắp xếp (phải)
    // Mỗi lần lặp, tìm phần tử nhỏ nhất từ phần chưa sắp xếp và đưa nó vào phần đã sắp xếp
    public static void selectionSort(int[] array) {
        int n = array.length;

        // Duyệt qua từng phần tử của mảng
        for (int i = 0; i < n - 1; i++) {
            // Tìm vị trí của phần tử nhỏ nhất trong phần chưa sắp xếp
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }

            // Hoán đổi phần tử nhỏ nhất với phần tử tại vị trí i
            if (minIndex != i) {
                int temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }
        }
    }

    // Hàm hiển thị mảng
    public static void displayArray(int[] array, String title) {
        System.out.println("\n" + title);
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    // Hàm nhập số lượng phần tử từ người dùng
    public static int getUserInput(Scanner scanner) {
        int number = 0;
        boolean validInput = false;

        while (!validInput) {
            System.out.print("Enter the number of array: ");

            // Kiểm tra xem đầu vào có phải là số không
            if (scanner.hasNextInt()) {
                number = scanner.nextInt();

                // Kiểm tra xem số đó có dương không
                if (number > 0) {
                    validInput = true;
                } else {
                    System.out.println("Error: Please enter a positive number!");
                }
            } else {
                System.out.println("Error: Please enter a valid integer!");
                scanner.nextLine(); // Xóa đầu vào không hợp lệ
            }
        }

        return number;
    }

    // Hàm tạo mảng ngẫu nhiên
    // Các số ngẫu nhiên nằm trong khoảng từ -100 đến 100
    public static int[] generateRandomArray(int size) {
        int[] array = new int[size];
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            // Tạo số ngẫu nhiên từ -100 đến 100
            array[i] = random.nextInt(201) - 100; // 201 để bao gồm 100, -100 để dịch về âm
        }

        return array;
    }

    // Hàm sao chép mảng để giữ nguyên mảng gốc
    public static int[] copyArray(int[] array) {
        int[] newArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        return newArray;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("========================================");
        System.out.println("   SELECTION SORT ALGORITHM PROGRAM");
        System.out.println("========================================");

        // Function 1: Nhập số lượng phần tử từ người dùng
        int arraySize = getUserInput(scanner);

        // Function 2: Tạo mảng ngẫu nhiên
        int[] originalArray = generateRandomArray(arraySize);
        int[] sortedArray = copyArray(originalArray);

        // Hiển thị mảng trước khi sắp xếp
        displayArray(originalArray, "Unsorted Array:");

        // Thực hiện Selection Sort
        selectionSort(sortedArray);

        // Hiển thị mảng sau khi sắp xếp
        displayArray(sortedArray, "Sorted Array:");

        System.out.println("\n========================================");
        System.out.println("Program finished successfully!");
        System.out.println("========================================");

        scanner.close();
    }
    // 5 1 12 -5 16 2 12 14
    // -5 1 12 5 16 2 12 14
    // -5 1 12 5 16 2 12 14
    //...
}
