package com.gonsalves.leetcode.LinkedList.easy;

public class MergeTwoSortedLists {
/*
    You are given the heads of two sorted linked lists list1 and list2.

    Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.

    Return the head of the merged linked list.

    Example 1:
        Input: list1 = [1,2,4], list2 = [1,3,4]
        Output: [1,1,2,3,4,4]
    Example 2:
        Input: list1 = [], list2 = []
        Output: []
    Example 3:
        Input: list1 = [], list2 = [0]
        Output: [0]

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

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode result = new ListNode();
        ListNode current = result;

        //1. Point to a new list node with the value that is smaller
        //2. Move the current pointer to the newly created node so can continue creating more nodes for our newly created list
        //3. iterate the pointer for the list where we took the value from

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = new ListNode(list1.val); //Point to a new list node with the value that is smaller
                current = current.next;                 //Move the pointer to the newly created node so can continue creating more nodes
                list1 = list1.next;                     //iterate the pointer for the list where we took the value from
            } else {
                current.next = new ListNode(list2.val);
                current = current.next;
                list2 = list2.next;

            }
        }
        /*
        This assumes you will not have lists that are uneven by more than one. If sizes are not difference of one,
        this would be a while loop.
         */
        while (list1 != null) {
            current.next = list1;
            current = current.next;
            list1 = list1.next;

        }
        while (list2 != null) {
            current.next = list2;
            current = current.next;
            list2 = list2.next;
        }
        return result.next;
    }



    public static void main(String[] args) {
        int k = 3;
        ListNode start1 = new ListNode(1,
                new ListNode(2,
                        new ListNode(4)));
        ListNode start2 = new ListNode(1,
                new ListNode(3,
                        new ListNode(4)));
        printList(start1);
        System.out.println();
        printList(start2);
        System.out.println();
        printList(mergeTwoLists(start1, start2));

    }






    public static void printList(ListNode head) {
        while(head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
    }
}
