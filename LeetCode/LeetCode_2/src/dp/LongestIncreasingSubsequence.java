package dp;

/**
 * Bài toán: Longest Increasing Subsequence (Dãy con tăng dài nhất).
 * <br>
 * Mục tiêu: Tìm độ dài của dãy con tăng dài nhất (không cần liên tiếp) trong mảng.
 * <br>
 * Giải thuật: Dynamic Programming (Quy hoạch động).
 * <br>
 * Tư duy:
 * - Định nghĩa dp[i] là độ dài của LIS kết thúc tại chỉ số i.
 * - Với mỗi i, duyệt ngược về j (từ 0 đến i-1).
 * - Nếu nums[i] > nums[j], ta có thể nối nums[i] vào sau dãy kết thúc tại j -> dp[i] = max(dp[i], dp[j] + 1).
 * - Kết quả là max của toàn bộ mảng dp.
 * - Cách tối ưu hơn: Dùng giải thuật Patience Sorting kết hợp Binary Search để đạt O(n log n).
 * <br>
 * Độ phức tạp:
 * - Time: O(n^2) - Hai vòng lặp lồng nhau.
 * - Space: O(n) - Mảng dp.
 */
public class LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int[] dp = new int[nums.length];

        int max = 1;

        for (int i = 0; i < nums.length; i++) {

            // Mỗi phần tử ít nhất tự tạo thành dãy con độ dài 1
            dp[i] = 1;

            for (int j = 0; j < i; j++) {

                // Nếu nums[i] lớn hơn nums[j], có thể nối tiếp dãy con kết thúc tại j
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            max = Math.max(max, dp[i]);
        }

        return max;
    }
}