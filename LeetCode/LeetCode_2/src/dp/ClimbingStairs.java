package dp;

/**
 * Bài toán: Climbing Stairs (Leo cầu thang).
 * <br>
 * Mục tiêu: Có n bậc thang. Mỗi bước có thể leo 1 hoặc 2 bậc. Hỏi có bao nhiêu cách để leo lên đỉnh.
 * <br>
 * Giải thuật: Dynamic Programming (Quy hoạch động).
 * <br>
 * Tư duy:
 * - Để đến bậc i, ta có thể đến từ bậc i-1 (bước 1 bậc) hoặc từ bậc i-2 (bước 2 bậc).
 * - Công thức truy hồi: `dp[i] = dp[i-1] + dp[i-2]`.
 * - Đây chính là dãy Fibonacci.
 * - Base case: dp[1] = 1, dp[2] = 2.
 * <br>
 * Độ phức tạp:
 * - Time: O(n).
 * - Space: O(1) (nếu chỉ lưu 2 biến thay vì cả mảng dp).
 */
public class ClimbingStairs {

    public int climbStairs(int n) {

        if (n <= 1) return 1;

        int prev1 = 1; // dp[i-1]
        int prev2 = 1; // dp[i-2] (Giả sử dp[0]=1)

        for (int i = 2; i <= n; i++) {
            int current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }
}

