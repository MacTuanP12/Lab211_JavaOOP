package dp;

/**
 * Bài toán: Decode Ways (Cách giải mã).
 * <br>
 * Mục tiêu: Đếm số cách giải mã chuỗi số thành chữ cái (A=1, B=2..., Z=26).
 * <br>
 * Giải thuật: Dynamic Programming.
 * <br>
 * Tư duy:
 * - `dp[i]` là số cách giải mã cho chuỗi con kết thúc tại i.
 * - Xét ký tự đơn `s[i]`: Nếu khác '0', `dp[i] += dp[i-1]`.
 * - Xét 2 ký tự `s[i-1]s[i]`: Nếu tạo thành số từ 10-26, `dp[i] += dp[i-2]`.
 * - Base case: `dp[0] = 1`.
 * <br>
 * Độ phức tạp:
 * - Time: O(n).
 * - Space: O(n).
 */
public class DecodeWays {

    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }

        int n = s.length();
        int[] dp = new int[n + 1];

        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            // One digit check
            int oneDigit = Integer.valueOf(s.substring(i - 1, i));
            if (oneDigit >= 1 && oneDigit <= 9) {
                dp[i] += dp[i - 1];
            }

            // Two digits check
            int twoDigits = Integer.valueOf(s.substring(i - 2, i));
            if (twoDigits >= 10 && twoDigits <= 26) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[n];
    }
}

