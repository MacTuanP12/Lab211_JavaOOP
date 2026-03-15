package array;

/**
 * Bài toán: Maximum Subarray (Dãy con liên tiếp có tổng lớn nhất).
 * <br>
 * Mục tiêu: Tìm dãy con (subarray) liên tiếp có tổng lớn nhất và trả về tổng đó.
 * <br>
 * Giải thuật: Kadane's Algorithm.
 * <br>
 * Tư duy:
 * - Duyệt qua mảng, duy trì biến `currentSum` là tổng của dãy con kết thúc tại vị trí hiện tại.
 * - Tại mỗi phần tử x: Ta có lựa chọn:
 *   1. Bắt đầu dãy con mới tại x (nếu tổng trước đó làm giảm giá trị của x, tức `currentSum` < 0).
 *   2. Nối x vào dãy con trước đó (`currentSum + x`).
 * - Công thức: `currentSum = max(x, currentSum + x)`.
 * - Cập nhật `maxSum` toàn cục.
 * <br>
 * Độ phức tạp:
 * - Time: O(n) - Duyệt mảng 1 lần.
 * - Space: O(1) - Chỉ dùng biến đơn.
 */
public class MaximumSubarray {

    public int maxSubArray(int[] nums) {

        int currentSum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {

            // Quyết định: nối tiếp dãy cũ hay bắt đầu dãy mới từ nums[i]
            // Nếu currentSum âm thì cộng vào sẽ làm giảm nums[i], nên thà bắt đầu mới từ nums[i] còn hơn.
            if (currentSum < 0) {
                currentSum = nums[i];
            } else {
                currentSum += nums[i];
            }

            // Cập nhật max toàn cục
            if (currentSum > maxSum) {
                maxSum = currentSum;
            }
        }

        return maxSum;
    }
}

