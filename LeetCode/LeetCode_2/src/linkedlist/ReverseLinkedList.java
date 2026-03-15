package linkedlist;

import util.ListNode;

/**
 * Bài toán: Reverse Linked List (Đảo ngược danh sách liên kết).
 * <br>
 * Mục tiêu: Đảo ngược các liên kết trong danh sách đơn.
 * <br>
 * Giải thuật: Iterative (Lặp).
 * <br>
 * Tư duy:
 * - Dùng 3 con trỏ: prev (trước), head (hiện tại), next (kế tiếp).
 * - Tại mỗi bước:
 *   1. Lưu node tiếp theo: next = head.next
 *   2. Đảo chiều mũi tên: head.next = prev
 *   3. Tiến prev lên: prev = head
 *   4. Tiến head lên: head = next
 * - Kết thúc khi head == null, lúc này prev là đầu danh sách mới.
 * <br>
 * Độ phức tạp:
 * - Time: O(n) - Duyệt qua danh sách 1 lần.
 * - Space: O(1) - Chỉ dùng biến tạm.
 */
public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {

        ListNode prev = null;

        while (head != null) {

            ListNode next = head.next; // Lưu tham chiếu đến node tiếp theo

            head.next = prev; // Đảo chiều liên kết về phía sau

            prev = head; // Di chuyển con trỏ prev lên

            head = next; // Di chuyển con trỏ head lên
        }

        return prev; // prev lúc này là node đầu của danh sách đã đảo ngược
    }
}