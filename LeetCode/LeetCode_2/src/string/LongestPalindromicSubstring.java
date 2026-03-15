package string;

/**
 * Bài toán: Longest Palindromic Substring (Chuỗi con đối xứng dài nhất).
 * <br>
 * Mục tiêu: Tìm chuỗi con dài nhất mà đọc xuôi ngược đều giống nhau.
 * <br>
 * Giải thuật: Expand Around Center (Mở rộng từ tâm).
 * <br>
 * Tư duy:
 * - Một palindrome có thể mở rộng từ tâm ra 2 bên.
 * - Có 2n - 1 tâm (n tâm là ký tự, n-1 tâm là khoảng giữa 2 ký tự).
 * - Duyệt qua từng vị trí i, coi nó là tâm lẻ (aba) và tâm chẵn (abba).
 * - Mở rộng left và right chừng nào còn đối xứng.
 * - Cập nhật max length và vị trí start.
 * <br>
 * Độ phức tạp:
 * - Time: O(n^2) - Mỗi tâm mở rộng tối đa O(n).
 * - Space: O(1).
 */
public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {

        if (s == null || s.length() < 1) return "";

        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {

            // Trường hợp tâm là 1 ký tự (VD: "aba")
            int len1 = expandAroundCenter(s, i, i);

            // Trường hợp tâm là khoảng giữa 2 ký tự (VD: "abba")
            int len2 = expandAroundCenter(s, i, i + 1);

            int len = Math.max(len1, len2);

            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return right - left - 1; // Độ dài palindrome tìm được
    }
}

