package array;

/**
 * Bài toán: Product of Array Except Self (Tích của mảng ngoại trừ chính nó).
 * <br>
 * Mục tiêu: Trả về mảng result sao cho result[i] bằng tích tất cả các phần tử trong nums ngoại trừ nums[i].
 * Lưu ý: Không được dùng phép chia và độ phức tạp phải là O(n).
 * <br>
 * Giải thuật: Prefix Product & Suffix Product (Tích tiền tố & Tích hậu tố).
 * <br>
 * Tư duy:
 * - result[i] = (Tích các số bên trái i) * (Tích các số bên phải i).
 * - Bước 1: Tính tích bên trái (prefix) cho mỗi vị trí và lưu vào mảng kết quả.
 * - Bước 2: Duyệt ngược từ phải sang trái, duy trì biến tích bên phải (suffix) và nhân trực tiếp vào mảng kết quả.
 * - Như vậy không cần dùng thêm mảng phụ nào ngoài mảng kết quả (Space O(1) nếu không tính mảng output).
 * <br>
 * Độ phức tạp:
 * - Time: O(n) - 2 vòng lặp rời nhau.
 * - Space: O(1) - Chỉ dùng biến suffix (mảng output không tính vào complexity theo đề bài).
 */
public class ProductExceptSelf {

    public int[] productExceptSelf(int[] nums) {

        int n = nums.length;
        int[] result = new int[n];

        // Bước 1: Tính tích các phần tử bên trái (Prefix Product)
        // result[i] sẽ chứa tích của nums[0]...nums[i-1]
        result[0] = 1;
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        // Bước 2: Tính tích các phần tử bên phải (Suffix Product) và nhân vào result
        int rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {

            result[i] = result[i] * rightProduct;

            rightProduct = rightProduct * nums[i];
        }

        return result;
    }
}

