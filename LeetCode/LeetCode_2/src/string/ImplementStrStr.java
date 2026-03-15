package string;

/**
 * Bài toán: Implement strStr() (Hiện thực hàm tìm kiếm chuỗi con).
 * <br>
 * Mục tiêu: Trả về chỉ số xuất hiện đầu tiên của needle trong haystack, hoặc -1 nếu không tìm thấy.
 * <br>
 * Giải thuật: Sliding Window (Cửa sổ trượt) hoặc KMP (Knuth-Morris-Pratt).
 * <br>
 * Tư duy:
 * - Cách đơn giản nhất: Dùng `haystack.indexOf(needle)`.
 * - Cách thủ công (Sliding Window):
 *   - Duyệt i từ 0 đến n - m.
 *   - Tại mỗi i, kiểm tra xem đoạn con [i, i+m] có khớp với needle không.
 *   - Nếu khớp -> trả về i.
 * - Cách nâng cao (KMP): Xây dựng bảng prefix function để tránh so sánh lặp lại (Time O(N+M)).
 * <br>
 * Độ phức tạp:
 * - Time: O(N*M) - Cách đơn giản. O(N+M) - KMP.
 * - Space: O(1).
 */
public class ImplementStrStr {

    public int strStr(String haystack, String needle) {

        if (needle.length() == 0) return 0;
        if (haystack.length() < needle.length()) return -1;

        // Cách đơn giản O(N*M)
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {

            int j = 0;
            while (j < needle.length() && haystack.charAt(i + j) == needle.charAt(j)) {
                j++;
            }

            if (j == needle.length()) {
                return i;
            }
        }

        return -1;
    }
}

