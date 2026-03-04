import java.util.Random;
import java.util.Scanner;

/**

 * Chương trình sắp xếp mảng số nguyên sử dụng thuật toán Merge Sort
 *
 * Merge Sort là thuật toán "chia để trị" (divide and conquer):
 * - Chia mảng thành các phần nhỏ cho đến khi mỗi phần chỉ có 1 phần tử
 * - Gộp các phần đã sắp xếp lại với nhau cho đến khi có mảng hoàn chỉnh
 * - Độ phức tạp: O(n*log(n)) - rất hiệu quả với mảng lớn
 *
 * Ví dụ: Mảng [38, 27, 43, 3, 9, 82, 10]
 * Bước chia:
 *   [38, 27, 43, 3, 9, 82, 10]
 *   [38, 27, 43, 3] [9, 82, 10]
 *   [38, 27] [43, 3] [9, 82] [10]
 *   [38] [27] [43] [3] [9] [82] [10]
 *
 * Bước gộp:
 *   [27, 38] [3, 43] [9, 82] [10]
 *   [3, 27, 38, 43] [9, 10, 82]
 *   [3, 9, 10, 27, 38, 43, 82]
 */
public class Main {


    public static int getPositiveInteger(Scanner scanner) {
        int number;
        while (true) {
            try {
                System.out.print( "Enter number of array: ");
                number = Integer.parseInt(scanner.nextLine().trim());

                // Kiểm tra số phải > 0
                if (number <= 0) {
                    System.out.println("Please enter a positive number!");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid integer.");
            }
        }
        return number;
    }


    public static int[] generateRandomArray(int size) {
        int[] array = new int[size];
        Random random = new Random();

        // Tạo số ngẫu nhiên từ 0 đến 99
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(100);
        }

        return array;
    }


    public static void displayArray(int[] array) {
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
     * Hàm chính thực hiện Merge Sort (Divide - Chia)
     * Main merge sort function that divides the array recursively
     *
     * Cách hoạt động:
     * 1. Nếu mảng có 1 phần tử hoặc rỗng -> đã sắp xếp, return
     * 2. Tìm điểm giữa của mảng
     * 3. Chia mảng thành 2 nửa: trái và phải
     * 4. Đệ quy sắp xếp nửa trái
     * 5. Đệ quy sắp xếp nửa phải
     * 6. Gộp 2 nửa đã sắp xếp

     */
    public static void mergeSort(int[] array, int left, int right) {
        // Điều kiện dừng: nếu left >= right thì mảng chỉ có 1 phần tử hoặc không hợp lệ
        if (left < right) {
            // Tìm điểm giữa để chia mảng làm 2 phần
            // Ví dụ: left=0, right=6 -> middle=3
            int middle = left + (right - left) / 2;

            // Đệ quy sắp xếp nửa trái [left...middle]
            mergeSort(array, left, middle);

            // Đệ quy sắp xếp nửa phải [middle+1...right]
            mergeSort(array, middle + 1, right);

            // Gộp 2 nửa đã sắp xếp
            merge(array, left, middle, right);
        }
    }

    /**
     * Hàm gộp 2 mảng con đã sắp xếp thành 1 mảng sắp xếp (Conquer - Gộp)
     * Merges two sorted subarrays into one sorted array
     *
     * Cách hoạt động:
     * - Mảng con trái: array[left...middle]
     * - Mảng con phải: array[middle+1...right]
     * - So sánh từng phần tử của 2 mảng con và đưa phần tử nhỏ hơn vào mảng chính
     *
     * Ví dụ:
     * Mảng con trái: [3, 27, 38, 43]
     * Mảng con phải: [9, 10, 82]
     * Kết quả: [3, 9, 10, 27, 38, 43, 82]
     *

     */
    public static void merge(int[] array, int left, int middle, int right) {
        // Tính kích thước của 2 mảng con
        int n1 = middle - left + 1; // Kích thước mảng con trái
        int n2 = right - middle;     // Kích thước mảng con phải

        // Tạo 2 mảng tạm để chứa dữ liệu
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        // Copy dữ liệu vào mảng trái
        for (int i = 0; i < n1; i++) {
            leftArray[i] = array[left + i];
        }

        // Copy dữ liệu vào mảng phải
        for (int j = 0; j < n2; j++) {
            rightArray[j] = array[middle + 1 + j];
        }

        // Gộp 2 mảng tạm vào mảng chính
        int i = 0; // Chỉ số ban đầu của mảng con trái
        int j = 0; // Chỉ số ban đầu của mảng con phải
        int k = left; // Chỉ số ban đầu của mảng đã gộp

        // So sánh từng phần tử của 2 mảng con và đưa phần tử nhỏ hơn vào mảng chính
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // Copy các phần tử còn lại của leftArray (nếu có)
        while (i < n1) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        // Copy các phần tử còn lại của rightArray (nếu có)
        while (j < n2) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("====== MERGE SORT ALGORITHM ======");

        // Function 1: Nhập số lượng phần tử của mảng
        int arraySize = getPositiveInteger(scanner);

        // Function 2: Tạo mảng ngẫu nhiên
        int[] array = generateRandomArray(arraySize);

        // Hiển thị mảng trước khi sắp xếp
        System.out.print("Unsorted array: ");
        displayArray(array);

        // Thực hiện Merge Sort
        mergeSort(array, 0, array.length - 1);

        // Hiển thị mảng sau khi sắp xếp
        System.out.print("Sorted array: ");
        displayArray(array);

        scanner.close();
    }
}