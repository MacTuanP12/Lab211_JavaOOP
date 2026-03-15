package linkedlist;

import util.ListNode;

/**
 * Bài toán: Palindrome Linked List (Danh sách liên kết đối xứng).
 * <br>
 * Mục tiêu: Kiểm tra danh sách liên kết có phải là palindrome không.
 * <br>
 * Giải thuật: Find Middle + Reverse + Compare.
 * <br>
 * Tư duy:
 * - Để kiểm tra đối xứng, ta cần xem nửa đầu và nửa sau (đảo ngược) có giống nhau không.
 * - Bước 1: Tìm middle.
 * - Bước 2: Đảo ngược nửa sau.
 * - Bước 3: So sánh từng node nửa đầu và nửa sau.
 * - (Optional) Bước 4: Đảo ngược lại nửa sau để khôi phục danh sách ban đầu.
 * <br>
 * Độ phức tạp:
 * - Time: O(n).
 * - Space: O(1).
 */
public class PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        // Tìm middle
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse nửa sau
        ListNode prev = null;
        ListNode curr = slow; // slow có thể là giữa (lẻ) hoặc bắt đầu nửa sau (chẵn)

        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }

        // So sánh
        ListNode left = head;
        ListNode right = prev; // Head của nửa sau

        while (right != null) { // Chỉ cần so sánh đến hết nửa sau
            if (left.val != right.val) {
                return false;
            }
            left = left.next;
            right = right.next;
        }

        return true;
    }
}

