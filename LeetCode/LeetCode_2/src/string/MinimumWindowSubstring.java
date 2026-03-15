package string;

import java.util.HashMap;
import java.util.Map;

/**
 * Bài toán: Minimum Window Substring (Cửa sổ nhỏ nhất chứa đầy đủ ký tự).
 * <br>
 * Mục tiêu: Tìm chuỗi con nhỏ nhất của S sao cho chứa tất cả các ký tự trong T (bao gồm cả số lượng lặp lại).
 * <br>
 * Giải thuật: Sliding Window (Cửa sổ trượt).
 * <br>
 * Tư duy:
 * - Dùng Map (hoặc mảng 128) để đếm tần suất ký tự trong T.
 * - Dùng 2 con trỏ left, right để duyệt S.
 * - Mở rộng right để tìm kiếm các ký tự cần thiết. Giảm count khi tìm thấy ký tự trong T.
 * - Khi cửa sổ đã hợp lệ (đủ số lượng ký tự cần thiết):
 *   - Cập nhật độ dài min.
 *   - Thu hẹp left để tìm cửa sổ nhỏ hơn.
 *   - Nếu loại bỏ ký tự cần thiết -> cửa sổ không còn hợp lệ -> tiếp tục mở right.
 * <br>
 * Độ phức tạp:
 * - Time: O(N + M).
 * - Space: O(1) (bảng mã ASCII cố định 128).
 */
public class MinimumWindowSubstring {

    public String minWindow(String s, String t) {

        if (s.length() == 0 || t.length() == 0) return "";

        Map<Character, Integer> dictT = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            int count = dictT.getOrDefault(t.charAt(i), 0);
            dictT.put(t.charAt(i), count + 1);
        }

        int required = dictT.size();
        int left = 0, right = 0;
        int formed = 0;

        Map<Character, Integer> windowCounts = new HashMap<>();
        int[] ans = {-1, 0, 0}; // length, left, right

        while (right < s.length()) {

            char c = s.charAt(right);
            int count = windowCounts.getOrDefault(c, 0);
            windowCounts.put(c, count + 1);

            if (dictT.containsKey(c) && windowCounts.get(c).intValue() == dictT.get(c).intValue()) {
                formed++;
            }

            // Try and contract the window till the point where it ceases to be 'desirable'
            while (left <= right && formed == required) {
                c = s.charAt(left);

                if (ans[0] == -1 || right - left + 1 < ans[0]) {
                    ans[0] = right - left + 1;
                    ans[1] = left;
                    ans[2] = right;
                }

                windowCounts.put(c, windowCounts.get(c) - 1);
                if (dictT.containsKey(c) && windowCounts.get(c).intValue() < dictT.get(c).intValue()) {
                    formed--;
                }

                left++;
            }

            right++;
        }

        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }
}

