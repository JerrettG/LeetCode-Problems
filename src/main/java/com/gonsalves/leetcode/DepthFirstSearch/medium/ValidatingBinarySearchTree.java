package com.gonsalves.leetcode.DepthFirstSearch.medium;



import java.util.LinkedList;
import java.util.Queue;

public class ValidatingBinarySearchTree {

    /*
    Given the root of a binary tree, determine if it is a valid binary search tree (BST).

    A valid BST is defined as follows:

    The left subtree of a node contains only nodes with keys less than the node's key.
    The right subtree of a node contains only nodes with keys greater than the node's key.
    Both the left and right subtrees must also be binary search trees.

    Example 1:
        Input: root = [2,1,3]
        Output: true

    Example 2:
        Input: root = [5,1,4,null,null,3,6]
        Output: false
        Explanation: The root node's value is 5 but its right child's value is 4.

    Constraints:
        The number of nodes in the tree is in the range [1, 104].
        -231 <= Node.val <= 231 - 1

     */

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) {this.val = val;}
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * This method uses Depth-first Search to validate if a tree is a Binary Search tree. It accomplishes this by
     * validating that the left node is less than the root node and the right node is greater than the root node. It also
     * traverses the left and right branches to validate that all nodes in the left branch are less than the root and all
     * nodes in the right branch are greater than the root node. It is able to accomplish this by using lower and upper
     * limits in its recursive method call which first verifies its left and right node conditions, setting the upper limit
     * to the root node value when called on the left branch and changing the lower limit to the root node value on the
     * right branch. Doing so, we know that every node on the left branch has to be less than root because when the
     * left node calls the validate method on its right branch, it will compare itself to the higher limit, which is the root
     * node's value.
     * @param root the root of the tree to be validated
     * @return true if root is a valid Binary Search Tree and false if not
     */
     public static boolean isValidBST(TreeNode root) {

      return validate (root, Long.MIN_VALUE, Long.MAX_VALUE);
     }

     private static boolean validate(TreeNode currentNode, long low, long high) {
      if (currentNode == null)
       return true;
            /*check to see if value is less than root value (right branch is invalid)
              or value is greater than root value (left branch is invalid)
            */
      if (currentNode.val <= low || currentNode.val >= high)
       return false;

      return validate(currentNode.left, low, currentNode.val) && validate(currentNode.right, currentNode.val, high);
     }

    private static void test(TreeNode inputRoot, boolean expected) {
        boolean actual = isValidBST(inputRoot);

        System.out.println("Input: ");
        printTree(inputRoot);

        System.out.println("Actual: " + actual);
        System.out.println("Expected: " + expected);
        System.out.println();
    }

    private static void printTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        StringBuilder sb = new StringBuilder("[");
        while (queue.size() > 0) {
            TreeNode currentNode = queue.poll();

            if (currentNode != null)
                sb.append(currentNode.val).append(", ");
            if (currentNode != null && currentNode.left != null)
                queue.add(currentNode.left);
            if (currentNode != null && currentNode.right != null)
                queue.add(currentNode.right);
        }
        sb.replace(sb.lastIndexOf(", "), sb.lastIndexOf(", ")+1, "]");

        System.out.println(sb.toString());
    }

     public static void main(String[] args) {
        TreeNode input1 = new TreeNode(2,
                new TreeNode(1), new TreeNode(3));
        boolean expected = true;
        test(input1, expected);

        TreeNode input2 = new TreeNode(5,
                new TreeNode(1),
                new TreeNode(4,
                        new TreeNode(3),
                        new TreeNode(6)));
        expected = false;
        test(input2, expected);
     }



}
