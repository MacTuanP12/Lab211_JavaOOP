package linkedlist;

import util.ListNode;

/**
 * Bài toán: Linked List Cycle (Phát hiện chu trình trong danh sách liên kết).
 * <br>
 * Mục tiêu: Xác định xem Linked List có chu trình (vòng lặp) hay không.
 * <br>
 * Giải thuật: Floyd's Cycle Detection (Tortoise and Hare - Thỏ và Rùa).
 * <br>
 * Tư duy:
 * - Dùng 2 con trỏ: `slow` đi 1 bước, `fast` đi 2 bước.
 * - Nếu có chu trình, `fast` sẽ đuổi kịp `slow` tại một điểm nào đó bên trong vòng lặp.
 * - Nếu `fast` chạm tới null -> không có chu trình.
 * <br>
 * Độ phức tạp:
 * - Time: O(n).
 * - Space: O(1).
 */
public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {

        if (head == null) return false;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }
}

