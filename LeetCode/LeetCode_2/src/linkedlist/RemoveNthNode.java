package linkedlist;

import util.ListNode;

/**
 * Bài toán: Remove Nth Node From End of List (Xóa phần tử thứ N từ cuối lên).
 * <br>
 * Mục tiêu: Xóa node thứ n tính từ cuối danh sách.
 * <br>
 * Giải thuật: Two Pointers (Hai con trỏ - Cửa sổ kích thước n).
 * <br>
 * Tư duy:
 * - Dùng `fast` đi trước `n` bước.
 * - Sau đó cho `slow` và `fast` cùng đi cho đến khi `fast` chạm cuối.
 * - Lúc này `slow` sẽ đứng ngay trước node cần xóa.
 * - Thực hiện `slow.next = slow.next.next`.
 * - Lưu ý: Dùng node giả `dummy` trỏ vào head để xử lý trường hợp xóa head.
 * <br>
 * Độ phức tạp:
 * - Time: O(n).
 * - Space: O(1).
 */
public class RemoveNthNode {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode fast = dummy;
        ListNode slow = dummy;

        // Fast đi trước n + 1 bước (để slow dừng trước node cần xóa)
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // Xóa node
        slow.next = slow.next.next;

        return dummy.next;
    }
}

