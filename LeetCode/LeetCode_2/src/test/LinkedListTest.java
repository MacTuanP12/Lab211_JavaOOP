package test;

import linkedlist.*;
import util.*;

public class LinkedListTest {

    public static void run() {
        testLinkedList();
        testLinkedListCycle();
        testDetectCycle();
    }

    private static void testLinkedList() {
        System.out.println("==== Reverse LinkedList ====");
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        ReverseLinkedList solution = new ReverseLinkedList();
        ListNode result = solution.reverseList(head);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
        System.out.println();
    }

    private static void testLinkedListCycle() {
        System.out.println("==== Linked List Cycle ====");
        LinkedListCycle solution = new LinkedListCycle();
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next; // Create cycle
        System.out.println(solution.hasCycle(head));
    }

    private static void testDetectCycle() {
        System.out.println("==== Detect Cycle Linked List ====");
        DetectCycle solution = new DetectCycle();
        ListNode head = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node0 = new ListNode(0);
        ListNode node4 = new ListNode(-4);

        head.next = node2;
        node2.next = node0;
        node0.next = node4;
        node4.next = node2; // Cycle back to node 2 (index 1)

        ListNode cycleNode = solution.detectCycle(head);

        if (cycleNode != null) {
            System.out.println("Cycle detected at node with value: " + cycleNode.val);
        } else {
            System.out.println("No cycle detected");
        }
    }
}

