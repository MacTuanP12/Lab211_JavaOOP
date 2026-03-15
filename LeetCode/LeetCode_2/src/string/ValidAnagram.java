package string;

/**
 * Bài toán: Valid Anagram (Kiểm tra Anagram).
 * <br>
 * Mục tiêu: Kiểm tra xem s và t có phải là hoán vị của nhau không (cùng số lượng mỗi ký tự).
 * <br>
 * Giải thuật: Counting Characters (Đếm ký tự).
 * <br>
 * Tư duy:
 * - Nếu độ dài khác nhau -> false.
 * - Dùng mảng `count` kích thước 26 (cho 'a'-'z').
 * - Duyệt qua s, tăng count. Duyệt qua t, giảm count.
 * - Nếu bất kỳ phần tử nào trong count khác 0 -> false.
 * <br>
 * Độ phức tạp:
 * - Time: O(n) - Duyệt 2 chuỗi.
 * - Space: O(1) - Mảng cố định 26 phần tử (hoặc O(m) nếu dùng HashMap với bảng mã lớn hơn).
 */
public class ValidAnagram {

    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) return false;

        int[] count = new int[26];

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        for (int c : count) {
            if (c != 0) return false;
        }

        return true;
    }
}

