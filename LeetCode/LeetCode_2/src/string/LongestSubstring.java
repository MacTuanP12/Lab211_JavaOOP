package string;

import java.util.*;

/**
 * Bài toán: Longest Substring Without Repeating Characters (Chuỗi con dài nhất không có ký tự trùng).
 * <br>
 * Mục tiêu: Tìm độ dài của chuỗi con dài nhất mà không có ký tự nào lặp lại.
 * <br>
 * Giải thuật: Sliding Window (Cửa sổ trượt) + Set.
 * <br>
 * Tư duy:
 * - Dùng 2 con trỏ left và right định nghĩa cửa sổ [left, right].
 * - Mở rộng right để thêm ký tự vào cửa sổ.
 * - Nếu ký tự mới đã tồn tại trong Set (trùng lặp), ta thu hẹp cửa sổ từ bên trái (tăng left)
 *   và xóa ký tự tại left cũ khỏi Set cho đến khi hết trùng.
 * - Cập nhật độ dài max sau mỗi bước mở rộng.
 * - Cách tối ưu hơn: Dùng Map lưu index của ký tự gần nhất để nhảy left nhanh hơn thay vì tăng từng bước.
 * <br>
 * Độ phức tạp:
 * - Time: O(n) - Mỗi ký tự được thêm và xóa tối đa 1 lần.
 * - Space: O(min(n, m)) - Set chứa các ký tự duy nhất (m là bảng mã ký tự).
 */
public class LongestSubstring {

    public int lengthOfLongestSubstring(String s) {

        Set<Character> set = new HashSet<>();

        int left = 0;
        int max = 0;

        for (int right = 0; right < s.length(); right++) {

            // Nếu ký tự tại right đã có trong set, thu hẹp cửa sổ từ trái
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }

            set.add(s.charAt(right));

            max = Math.max(max, right - left + 1);
        }

        return max;
    }
}