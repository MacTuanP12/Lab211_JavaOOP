package string;

/**
 * Bài toán: String to Integer (atoi) (Chuyển chuỗi sang số nguyên).
 * <br>
 * Mục tiêu: Mô phỏng hàm atoi của C. Xử lý khoảng trắng, dấu, và tràn số (overflow).
 * <br>
 * Giải thuật: Simulation (Mô phỏng).
 * <br>
 * Tư duy:
 * - Bỏ qua khoảng trắng đầu.
 * - Kiểm tra dấu (+/-).
 * - Duyệt qua các ký tự số:
 *   - Tính `res = res * 10 + digit`.
 *   - Kiểm tra tràn trước khi nhân: `if (res > Integer.MAX_VALUE / 10 || ...)`
 *   - Nếu tràn thì trả về MAX hoặc MIN tùy dấu.
 * - Dừng khi gặp ký tự không phải số.
 * <br>
 * Độ phức tạp:
 * - Time: O(n).
 * - Space: O(1).
 */
public class StringToInteger {

    public int myAtoi(String s) {
        if (s == null || s.length() == 0) return 0;

        int i = 0;
        int n = s.length();
        int sign = 1;
        int res = 0;
        int MAX = Integer.MAX_VALUE;
        int MIN = Integer.MIN_VALUE;

        // 1. Skip spaces
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        if (i >= n) return 0;

        // 2. Check sign
        if (s.charAt(i) == '-') {
            sign = -1;
            i++;
        } else if (s.charAt(i) == '+') {
            i++;
        }

        // 3. Process digits
        while (i < n && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';

            // Check overflow
            // Nếu res > MAX/10 thì nhân 10 chắc chắn tràn
            // Nếu res == MAX/10 thì chỉ thêm được tối đa 7 (vì MAX tận cùng là 7)
            if (res > MAX / 10 || (res == MAX / 10 && digit > 7)) {
                return (sign == 1) ? MAX : MIN;
            }

            res = res * 10 + digit;
            i++;
        }

        return res * sign;
    }
}

