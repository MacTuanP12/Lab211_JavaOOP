package dp;

import java.util.Arrays;

/**
 * Bài toán: Coin Change (Đổi tiền).
 * <br>
 * Mục tiêu: Tìm số lượng đồng xu ít nhất cần thiết để tạo nên một số tiền amount cho trước.
 * <br>
 * Giải thuật: Dynamic Programming (Quy hoạch động) - Bottom Up.
 * <br>
 * Tư duy:
 * - Định nghĩa dp[i] là số đồng xu ít nhất để tạo nên số tiền i.
 * - Công thức truy hồi: dp[i] = min(dp[i], dp[i - coin] + 1) với mọi đồng xu <= i.
 * - Khởi tạo dp[0] = 0 (cần 0 đồng xu để tạo ra 0 tiền).
 * - Các giá trị khác khởi tạo bằng một số lớn hơn amount (vô cực).
 * - Nếu sau khi tính toán dp[amount] vẫn lớn hơn amount -> không thể đổi được -> return -1.
 * <br>
 * Độ phức tạp:
 * - Time: O(S * n) - S là amount, n là số lượng loại đồng xu.
 * - Space: O(S) - Mảng dp kích thước S+1.
 */
public class CoinChange {

    public int coinChange(int[] coins, int amount) {

        int[] dp = new int[amount + 1];

        // Khởi tạo giá trị ban đầu là amount + 1 (lớn hơn số lượng đồng xu tối đa có thể có là amount nếu dùng xu 1)
        Arrays.fill(dp, amount + 1);

        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {

            for (int coin : coins) {

                if (coin <= i) {
                    // Nếu dùng đồng coin này, số lượng xu = dp[phần còn lại] + 1
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }
}