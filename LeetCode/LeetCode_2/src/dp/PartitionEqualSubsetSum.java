package dp;

/**
 * Bài toán: Partition Equal Subset Sum (Chia tập hợp con có tổng bằng nhau).
 * <br>
 * Mục tiêu: Kiểm tra xem có thể chia mảng thành 2 tập có tổng bằng nhau không.
 * Tương đương tìm tập con có tổng = SUM / 2.
 * <br>
 * Giải thuật: Dynamic Programming (Knapsack 0/1).
 * <br>
 * Tư duy:
 * - Tính tổng mảng. Nếu tổng lẻ -> False.
 * - Bài toán trở thành: Có tồn tại tập con nào có tổng bằng `target = sum / 2` không?
 * - `dp[i]` = true nếu có thể tạo ra tổng `i`.
 * - Duyệt qua từng số `num`, cập nhật `dp[j] = dp[j] || dp[j - num]`.
 * <br>
 * Độ phức tạp:
 * - Time: O(n * sum).
 * - Space: O(sum).
 */
public class PartitionEqualSubsetSum {

    public boolean canPartition(int[] nums) {

        int sum = 0;
        for (int num : nums) sum += num;

        if (sum % 2 != 0) return false;

        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];

        dp[0] = true; // Tổng bằng 0 luôn tạo được (tập rỗng)

        for (int num : nums) {
            // Duyệt ngược để tránh dùng 1 số nhiều lần cho cùng 1 tổng
            for (int j = target; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num];
            }
        }

        return dp[target];
    }
}

