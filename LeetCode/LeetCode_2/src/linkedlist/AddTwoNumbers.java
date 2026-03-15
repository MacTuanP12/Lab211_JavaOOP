package linkedlist;

import util.ListNode;

/**
 * Bài toán: Add Two Numbers (Cộng hai số).
 * <br>
 * Mục tiêu: Cộng hai số nguyên không âm được biểu diễn bởi danh sách liên kết (ngược).
 * Ví dụ: (2 -> 4 -> 3) + (5 -> 6 -> 4) = 7 -> 0 -> 8 (342 + 465 = 807).
 * <br>
 * Giải thuật: Simulation (Mô phỏng phép cộng toán học).
 * <br>
 * Tư duy:
 * - Duyệt qua cả 2 danh sách cùng lúc.
 * - Cộng giá trị của node hiện tại ở l1 và l2 (nếu có) cùng với biến nhớ (carry).
 * - Kết quả tại vị trí hiện tại là `sum % 10`.
 * - Biến nhớ mới là `sum / 10`.
 * - Tiếp tục cho đến khi cả 2 danh sách đều hết và không còn biến nhớ.
 * <br>
 * Độ phức tạp:
 * - Time: O(max(m, n)) - Duyệt qua danh sách dài hơn.
 * - Space: O(max(m, n)) - Tạo danh sách kết quả mới (độ dài bằng max + 1 là cùng).
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(0); // Node giả để giữ đầu danh sách
        ListNode current = dummy;

        int carry = 0;

        // Vòng lặp chạy khi còn node ở l1 HOẶC l2 HOẶC còn biến nhớ
        while (l1 != null || l2 != null || carry != 0) {

            int sum = carry; // Bắt đầu với biến nhớ từ bước trước

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            carry = sum / 10; // Tính nhớ cho bước sau

            current.next = new ListNode(sum % 10); // Tạo node mới chứa hàng đơn vị
            current = current.next;
        }

        return dummy.next; // Trả về node thật đầu tiên (sau dummy)
    }
}