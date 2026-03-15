package dp;

import java.util.List;

/**
 * Bài toán: Word Break (Tách từ).
 * <br>
 * Mục tiêu: Kiểm tra xem chuỗi s có thể được tách thành các từ trong từ điển wordDict không.
 * <br>
 * Giải thuật: Dynamic Programming.
 * <br>
 * Tư duy:
 * - `dp[i]` = true nếu `s.substring(0, i)` có thể tách được.
 * - Để tính `dp[i]`, ta duyệt j từ 0 đến i-1.
 * - Nếu `dp[j]` là true (phần đầu tách được) VÀ `s.substring(j, i)` có trong từ điển
 *   -> `dp[i]` = true.
 * <br>
 * Độ phức tạp:
 * - Time: O(n^2 * k) - n là độ dài chuỗi, k là độ dài max của từ (do hàm substring/equals tốn thời gian). Hoặc O(n^3).
 * - Space: O(n).
 */
public class WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {

        boolean[] dp = new boolean[s.length() + 1];

        // Chuỗi rỗng luôn tách được (không cần từ nào)
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {

            for (int j = 0; j < i; j++) {

                // Kiểm tra nếu phần đầu dp[j] tách được VÀ phần đuôi s[j...i] có trong dict
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break; // Tìm thấy 1 cách tách là đủ
                }
            }
        }

        return dp[s.length()];
    }
}

