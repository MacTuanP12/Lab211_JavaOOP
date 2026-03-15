package array;

/**
 * Bài toán: Rotate Array (Xoay mảng).
 * <br>
 * Mục tiêu: Xoay mảng sang phải k bước. k không âm.
 * Ví dụ: [1,2,3,4,5,6,7], k = 3 -> [5,6,7,1,2,3,4].
 * <br>
 * Giải thuật: Array Reversal (Đảo ngược mảng).
 * <br>
 * Tư duy:
 * - Cách 1 (Dùng mảng phụ): Backup mảng, sau đó gán lại theo index mới `(i + k) % n`. Tốn O(n) space.
 * - Cách 2 (Tối ưu Space O(1)): Dựa trên tính chất đảo ngược.
 *   1. Đảo ngược toàn bộ mảng: [7,6,5,4,3,2,1].
 *   2. Đảo ngược k phần tử đầu: [5,6,7, 4,3,2,1].
 *   3. Đảo ngược n-k phần tử còn lại: [5,6,7, 1,2,3,4].
 * - Lưu ý: k có thể lớn hơn n, nên cần `k = k % n`.
 * <br>
 * Độ phức tạp:
 * - Time: O(n) - Mỗi phần tử được for qua hằng số lần.
 * - Space: O(1) - Thao tác in-place.
 */
public class RotateArray {

    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0) return;

        int n = nums.length;
        k = k % n; // Xử lý trường hợp k >= n

        // Bước 1: Đảo ngược toàn bộ mảng
        reverse(nums, 0, n - 1);

        // Bước 2: Đảo ngược k phần tử đầu
        reverse(nums, 0, k - 1);

        // Bước 3: Đảo ngược phần còn lại
        reverse(nums, k, n - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;

            start++;
            end--;
        }
    }
}

