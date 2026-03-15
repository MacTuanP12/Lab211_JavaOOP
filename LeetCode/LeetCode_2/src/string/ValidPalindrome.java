package string;

/**
 * Bài toán: Valid Palindrome (Kiểm tra chuỗi đối xứng).
 * <br>
 * Mục tiêu: Kiểm tra xem chuỗi có phải là Palindrome không, chỉ xét chữ cái và số, bỏ qua ký tự đặc biệt, không phân biệt hoa thường.
 * <br>
 * Giải thuật: Two Pointers (Hai con trỏ).
 * <br>
 * Tư duy:
 * - Dùng 2 con trỏ left (đầu) và right (cuối).
 * - Di chuyển left sang phải đến khi gặp ký tự hợp lệ (Letter hoặc Digit).
 * - Di chuyển right sang trái đến khi gặp ký tự hợp lệ.
 * - So sánh ký tự tại left và right (đã lower case).
 * - Nếu khác nhau -> False.
 * - Tiếp tục cho đến khi left >= right.
 * <br>
 * Độ phức tạp:
 * - Time: O(n) - Duyệt chuỗi 1 lần.
 * - Space: O(1) - Không dùng thêm bộ nhớ đáng kể (in-place).
 */
public class ValidPalindrome {

    public boolean isPalindrome(String s) {

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {

            // Bỏ qua ký tự không phải chữ/số từ bên trái
            while (left < right && !Character.isLetterOrDigit(s.charAt(left)))
                left++;

            // Bỏ qua ký tự không phải chữ/số từ bên phải
            while (left < right && !Character.isLetterOrDigit(s.charAt(right)))
                right--;

            // So sánh
            if (Character.toLowerCase(s.charAt(left)) !=
                    Character.toLowerCase(s.charAt(right)))
                return false;

            left++;
            right--;
        }

        return true;
    }
}