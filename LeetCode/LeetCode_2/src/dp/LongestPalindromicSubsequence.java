package dp;

/**
 * Bài toán: Longest Palindromic Subsequence (Dãy con đối xứng dài nhất).
 * <br>
 * Mục tiêu: Tìm độ dài dãy con (subsequence - không cần liên tiếp) dài nhất là palindrome.
 * Ví dụ: "bbbab" -> "bbbb" (4).
 * <br>
 * Giải thuật: Dynamic Programming.
 * <br>
 * Tư duy:
 * - `dp[i][j]` là độ dài LPS của đoạn `s[i...j]`.
 * - Nếu `s[i] == s[j]`: `dp[i][j] = 2 + dp[i+1][j-1]` (cộng 2 đầu).
 * - Nếu `s[i] != s[j]`: `dp[i][j] = max(dp[i+1][j], dp[i][j-1])` (bỏ đầu hoặc bỏ cuối, lấy max).
 * - Duyệt i từ n-1 về 0, j từ i+1 đến n-1.
 * <br>
 * Độ phức tạp:
 * - Time: O(n^2).
 * - Space: O(n^2).
 */
public class LongestPalindromicSubsequence {

    public int longestPalindromeSubseq(String s) {

        int n = s.length();
        int[][] dp = new int[n][n];

        // Duyệt ngược từ cuối lên để đảm bảo các bài toán con (i+1, j-1) đã được tính
        for (int i = n - 1; i >= 0; i--) {

            dp[i][i] = 1; // Base case: 1 ký tự là palindrome độ dài 1

            for (int j = i + 1; j < n; j++) {

                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[0][n - 1];
    }
}

