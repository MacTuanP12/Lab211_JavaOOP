package linkedlist;

import util.ListNode;

/**
 * Bài toán: Reorder List (Sắp xếp lại danh sách).
 * <br>
 * Mục tiêu: Chuyển L0 -> L1 -> ... -> Ln-1 -> Ln thành L0 -> Ln -> L1 -> Ln-1 -> ...
 * <br>
 * Giải thuật: Find Middle + Reverse + Merge.
 * <br>
 * Tư duy:
 * - Bước 1: Tìm trung điểm (middle) của danh sách (dùng slow/fast).
 * - Bước 2: Đảo ngược nửa sau của danh sách.
 * - Bước 3: Trộn (merge) hai nửa danh sách xen kẽ nhau.
 * <br>
 * Độ phức tạp:
 * - Time: O(n).
 * - Space: O(1).
 */
public class ReorderList {

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        // 1. Tìm middle
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2. Reverse second half
        ListNode prev = null;
        ListNode curr = slow.next;
        slow.next = null; // Cắt đôi danh sách

        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        // prev bây giờ là head của nửa sau đã đảo ngược

        // 3. Merge two halves
        ListNode first = head;
        ListNode second = prev;

        while (second != null) {
            ListNode temp1 = first.next;
            ListNode temp2 = second.next;

            first.next = second;
            second.next = temp1;

            first = temp1;
            second = temp2;
        }
    }
}

