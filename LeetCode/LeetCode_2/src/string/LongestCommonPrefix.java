package string;

/**
 * Bài toán: Longest Common Prefix (Tiền tố chung dài nhất).
 * <br>
 * Mục tiêu: Tìm chuỗi tiền tố dài nhất xuất hiện ở đầu tất cả các chuỗi trong mảng.
 * <br>
 * Giải thuật: Horizontal Scanning (Quét ngang).
 * <br>
 * Tư duy:
 * - Lấy chuỗi đầu tiên làm `prefix`.
 * - Lần lượt so sánh `prefix` với các chuỗi tiếp theo.
 * - Cập nhật `prefix` là phần chung của `prefix` hiện tại và chuỗi đang xét.
 * - Nếu `prefix` rỗng -> dừng.
 * <br>
 * Độ phức tạp:
 * - Time: O(S) - S là tổng số ký tự của tất cả các chuỗi.
 * - Space: O(1) - Không dùng thêm bộ nhớ đáng kể.
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {

        if (strs == null || strs.length == 0) return "";

        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {

            while (strs[i].indexOf(prefix) != 0) {

                prefix = prefix.substring(0, prefix.length() - 1);

                if (prefix.isEmpty()) return "";
            }
        }

        return prefix;
    }
}

