package com.gonsalves.leetcode.LinkedList.easy;

public class ReverseLinkedList {
/*
    Given the head of a singly linked list, reverse the list, and return the reversed list.

    Example 1:
        Input: head = [1,2,3,4,5]
        Output: [5,4,3,2,1]
    Example 2:
        Input: head = [1,2]
        Output: [2,1]
    Example 3:
        Input: head = []
        Output: []

*/

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

     public static ListNode reverseList(ListNode head) {
         ListNode prev = null, current = head, next;
        // 1 -> 2 -> 3 -> 4 ->
         while (current != null) {
             //first iteration = 1st, second iteration = 2nd:
             next = current.next; //1st next points to 2                 2nd next points to 3
             current.next = prev; //1st the current (1) now points to 1  2nd current now points to the previous node (1)
             prev = current; //1st the previous is now pointing at the current position 1  2nd previous now points to current (2)
             current = next; //moves pointer to next node in list
         }

         return prev; //prev will equal 4 or the last node in the list after loop
    }

    public static void printList(ListNode head) {
        while(head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        int k = 10;
        ListNode start = new ListNode();
        ListNode previous = new ListNode(1);
        start.next = previous;
        for (int i = 0; i < k; i++) {
            ListNode current = new ListNode((int) (Math.random()*10));
            previous.next = current;
            previous = current;
        }
        printList(start.next);
        reverseList(start.next);
        System.out.println();
        printList(previous);

    }

}
