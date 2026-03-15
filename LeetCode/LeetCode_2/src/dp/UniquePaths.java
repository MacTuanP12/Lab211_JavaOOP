package dp;

/**
 * Bài toán: Unique Paths (Đường đi duy nhất).
 * <br>
 * Mục tiêu: Tìm số đường đi từ góc trên-trái (0,0) đến góc dưới-phải (m-1, n-1) của lưới m x n.
 * Chỉ được đi xuống hoặc sang phải.
 * <br>
 * Giải thuật: Dynamic Programming.
 * <br>
 * Tư duy:
 * - Tại ô (i, j), ta chỉ có thể đến từ ô trên (i-1, j) hoặc ô trái (i, j-1).
 * - `dp[i][j] = dp[i-1][j] + dp[i][j-1]`.
 * - Base case: Hàng đầu và cột đầu chỉ có 1 cách đi (luôn đi thẳng).
 * <br>
 * Độ phức tạp:
 * - Time: O(M * N).
 * - Space: O(M * N) (có thể tối ưu thành O(N)).
 */
public class UniquePaths {

    public int uniquePaths(int m, int n) {

        int[][] dp = new int[m][n];

        // Khởi tạo hàng đầu và cột đầu
        for (int i = 0; i < m; i++) dp[i][0] = 1;
        for (int j = 0; j < n; j++) dp[0][j] = 1;

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }
}

