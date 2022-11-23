package com.gonsalves.leetcode.LinkedList.medium;

import com.gonsalves.leetcode.LinkedList.easy.MiddleOfLinkedList;

public class DeleteMiddleNodeOfLinkedList {
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
    /**
     * This method uses the Slow and Fast (Tortoise and hare) pointer method in order to find the middle node of the list
     * and delete it. It accomplishes this by having one pointer move twice as fast (fast pointer) as the other pointer (slow).
     * For every 1 node slow moves, fast moves 2. This way, when fast is able to reach the end of the LinkedList, slow
     * will be directly in the middle of the List since they move at a 1:2 ratio.
     * @param head the starting node of the LinkedList
     * @return the LinkedList with the middle node removed
     */
    public static ListNode deleteMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        if (head == null || head.next == null)
            return null;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }
        prev.next = slow.next;
        return head;
    }


    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        ListNode input1 = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4,
                                        new ListNode(5,
                                                new ListNode(6)
                                        )
                                )
                        )
                )
        );
        ListNode answer1 = new ListNode(1,
                new ListNode(2,
                                new ListNode(3,
                                        new ListNode(5,
                                                new ListNode(6)
                                                )
                                        )
                            )
                );
        System.out.print("Input:  ");
        printList(input1);
        System.out.println();
        System.out.print("Result: " );
        printList(deleteMiddle(input1));
        System.out.println();
        System.out.print("Answer: ");
        printList(answer1);

    }
}
