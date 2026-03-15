package string;

import java.util.Stack;

/**
 * Bài toán: Valid Parentheses (Dấu ngoặc hợp lệ).
 * <br>
 * Mục tiêu: Kiểm tra xem các dấu ngoặc '(', ')', '{', '}', '[', ']' có đóng mở đúng thứ tự không.
 * <br>
 * Giải thuật: Stack (Ngăn xếp).
 * <br>
 * Tư duy:
 * - Khi gặp ngoặc mở: push vào stack.
 * - Khi gặp ngoặc đóng:
 *   - Kiểm tra stack có rỗng không (thừa ngoặc đóng).
 *   - Pop phần tử đầu stack ra xem có khớp cặp không (VD: '(' phải đi với ')').
 *   - Nếu không khớp -> false.
 * - Kết thúc: stack phải rỗng (không thừa ngoặc mở).
 * <br>
 * Độ phức tạp:
 * - Time: O(n).
 * - Space: O(n).
 */
public class ValidParentheses {

    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {

            if (c == '(') stack.push(')');
            else if (c == '{') stack.push('}');
            else if (c == '[') stack.push(']');
            else {
                // Nếu là ngoặc đóng
                if (stack.isEmpty() || stack.pop() != c) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}

