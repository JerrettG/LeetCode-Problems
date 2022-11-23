package com.gonsalves.leetcode.LinkedList.medium;

import com.gonsalves.leetcode.LinkedList.easy.MiddleOfLinkedList;

import java.util.Objects;

public class RemoveNthNodeFromEndOfList {

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ListNode listNode = (ListNode) o;
            return val == listNode.val && Objects.equals(next, listNode.next);
        }

        @Override
        public int hashCode() {
            return Objects.hash(val, next);
        }
    }

    public static ListNode removeNthFromEnd2Pass(ListNode head, int n) {
        int size = 0;
        int index = 0;
        ListNode start = head;
        while (head != null) {
            size++;
            head = head.next;
        }
        if (n >= size)
            return start.next;

        int indexNthFromEnd = size - n;
        ListNode prev = null;
        ListNode current = start;
        ListNode next = start.next;
        while (index != indexNthFromEnd) {
            index++;
            prev = current;
            current = next;
            next = next.next;
        }

        prev.next = next;

        return start;
    }

    /**
     * This method uses the Tortoise and Hare or Slow and Fast pointer method in order to find the nth node from the
     * end of the list and remove it. It does so by having one pointer that is n distance apart (fast) from the other (slow)
     * and iterating them at the same speed. By doing so, we are able to find the end of the LinkedList and the slow pointer
     * will be in the n+1 position from the end. So if the size of the list was 7 and n = 3, the slow would be at the 4th
     * position from the end of the list. We can also account for edge cases where n == size of the list by checking to see
     * if the fast has already reached the end of the list once we've spaced slow and fast n distance apart from each other
     * @param head the start of the LinkedList
     * @param n the position of the node to be removed from the list
     * @return the newly created list with the nth node removed;
     */
    public static ListNode removeNthFromEndTortoiseAndHare(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;

        for (int i = 0; i < n;i++)
            fast = fast.next;
        //At this point if fast is null it means that the nth node for deletion is equal to size of the list so we remove the first node
        if (fast == null)
            return head.next;

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;//slow is at the n+1 position from the end of the list so slow is at the previous node of the nth node


        return head;
    }


    public static void printList(ListNode head) {
        while(head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        ListNode input1 = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4))));
        ListNode answer1 =  new ListNode(1,
                new ListNode(2,
                        new ListNode(4)));
        System.out.print("Input:  ");
        printList(input1);
        System.out.println();
        System.out.print("Result: ");
        printList(removeNthFromEnd2Pass(input1, 2));
        System.out.println();
        System.out.print("Answer: ");
        printList(answer1);
        System.out.println("\n");

        ListNode input2 = new ListNode(1, new ListNode(2));
        ListNode answer2 = new ListNode(2);

        System.out.print("Input:  ");
        printList(input2);
        System.out.println();
        System.out.print("Result: ");
        printList(removeNthFromEndTortoiseAndHare(input2, 2));
        System.out.println();
        System.out.print("Answer: ");
        printList(answer2);
        System.out.println();
    }
}
