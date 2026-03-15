package linkedlist;

import util.ListNode;

/**
 * Bài toán: Intersection of Two Linked Lists (Giao điểm của hai danh sách).
 * <br>
 * Mục tiêu: Tìm node mà tại đó 2 danh sách bắt đầu giao nhau.
 * <br>
 * Giải thuật: Two Pointers (Switch Heads).
 * <br>
 * Tư duy:
 * - Cho pA chạy trên A, pB chạy trên B.
 * - Nếu pA hết A, chuyển sang đầu B.
 * - Nếu pB hết B, chuyển sang đầu A.
 * - Nếu có giao nhau, chúng sẽ gặp nhau tại giao điểm sau khi đi cùng quãng đường (lenA + lenB).
 * - Nếu không giao nhau, chúng sẽ cùng gặp nhau tại null (kết thúc).
 * <br>
 * Độ phức tạp:
 * - Time: O(n + m).
 * - Space: O(1).
 */
public class IntersectionLinkedLists {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA == null || headB == null) return null;

        ListNode pA = headA;
        ListNode pB = headB;

        while (pA != pB) {

            pA = (pA == null) ? headB : pA.next;
            pB = (pB == null) ? headA : pB.next;
        }

        return pA;
    }
}

