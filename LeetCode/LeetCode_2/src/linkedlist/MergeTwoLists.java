package linkedlist;

import util.ListNode;

/**
 * Bài toán: Merge Two Sorted Lists (Gộp hai danh sách đã sắp xếp).
 * <br>
 * Mục tiêu: Gộp hai danh sách liên kết đã sắp xếp tăng dần thành một danh sách mới cũng sắp xếp tăng dần.
 * <br>
 * Giải thuật: Two Pointers (Hai con trỏ) / Iteration.
 * <br>
 * Tư duy:
 * - Dùng 1 node giả (dummy) để làm mốc bắt đầu.
 * - So sánh giá trị đầu của l1 và l2.
 * - Chọn node nhỏ hơn nối vào danh sách kết quả và di chuyển con trỏ của danh sách đó.
 * - Lặp lại cho đến khi một trong hai danh sách hết.
 * - Nối phần còn lại của danh sách chưa hết vào cuối kết quả.
 * <br>
 * Độ phức tạp:
 * - Time: O(n + m) - Duyệt qua cả 2 danh sách.
 * - Space: O(1) - Chỉ thay đổi các liên kết (con trỏ next), không tạo node mới (ngoại trừ dummy).
 */
public class MergeTwoLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (l1 != null && l2 != null) {

            if (l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;
            }

            else {
                current.next = l2;
                l2 = l2.next;
            }

            current = current.next;
        }

        // Nếu còn thừa node ở danh sách nào thì nối thẳng vào đuôi
        current.next = (l1 != null) ? l1 : l2;

        return dummy.next;
    }
}