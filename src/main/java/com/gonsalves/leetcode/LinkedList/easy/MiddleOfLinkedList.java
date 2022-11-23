package com.gonsalves.leetcode.LinkedList.easy;

import java.util.List;

public class MiddleOfLinkedList {

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode middleNode2Pass(ListNode head) {
        int size = 0;
        ListNode start = head;
        while (head != null) {
            size++;
            head = head.next;
        }

        int index = 0;
        while (index != size/2) {
            index++;
            start = start.next;
        }
        return start;
    }

    /**
     * This method uses the Slow and Fast (Tortoise and hare) pointer method in order to find the middle node of the list
     * and accomplishes this by having one pointer move twice as fast (fast pointer) as the other pointer (slow).
     * For every 1 node slow moves, fast moves 2. This way, when fast is able to reach the end of the LinkedList, slow
     * will be directly in the middle of the List since they move at a 1:2 ratio.
     * @param head the starting node of the LinkedList
     * @return the middle node of the LinkedList
     */

    public static ListNode middleNodeTortoiseAndHare(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }


    public static void printList(ListNode head) {
        while(head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
    }

    public static void main(String[]args) {
        int k = 6;
        ListNode start = new ListNode();
        ListNode previous = start;
        ListNode answer = null;
        start.next = previous;
        for (int i = 0; i < k; i++) {
            ListNode current = new ListNode((int) (Math.random()*10));
            if (i == k/2)
                answer = current;
            previous.next = current;
            previous = current;
        }
        printList(start.next);
        System.out.println();
        ListNode result = middleNodeTortoiseAndHare(start.next);
        System.out.println("Passed: " + (result.val == answer.val));
    }
}
