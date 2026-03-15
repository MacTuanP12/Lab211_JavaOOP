package linkedlist;

import util.ListNode;

/**
 * Bài toán: Linked List Cycle II (Tìm điểm bắt đầu chu trình).
 * <br>
 * Mục tiêu: Trả về node bắt đầu của chu trình, hoặc null nếu không có.
 * <br>
 * Giải thuật: Floyd's Cycle Detection (Tortoise and Hare).
 * <br>
 * Tư duy:
 * - Bước 1: Xác định có chu trình (như bài 19).
 * - Bước 2: Tìm điểm bắt đầu.
 *   - Khi slow và fast gặp nhau, khoảng cách từ head đến điểm bắt đầu vòng lặp bằng khoảng cách từ điểm gặp nhau đến điểm bắt đầu vòng lặp.
 *   - Đặt `slow` về `head`. Giữ `fast` ở điểm gặp nhau.
 *   - Cho cả 2 đi cùng tốc độ (1 bước).
 *   - Điểm gặp nhau lần 2 chính là START của chu trình.
 * <br>
 * Độ phức tạp:
 * - Time: O(n).
 * - Space: O(1).
 */
public class DetectCycle {

    public ListNode detectCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;
        boolean hasCycle = false;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                hasCycle = true;
                break;
            }
        }

        if (!hasCycle) return null;

        // Reset slow về head
        slow = head;

        // Di chuyển cùng tốc độ đến khi gặp nhau
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
}

