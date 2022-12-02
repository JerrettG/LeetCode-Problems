package com.gonsalves.leetcode.DepthFirstSearch.easy;

import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class MergeTwoBinaryTrees {
    /*
    You are given two binary trees root1 and root2.

    Imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not. You need to merge the two trees into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of the new tree.

    Return the merged tree.

    Note: The merging process must start from the root nodes of both trees.

    Example 1:
        Input: root1 = [1,3,2,5], root2 = [2,1,3,null,4,null,7]
        Output: [3,4,5,5,4,null,7]

    Example 2:
        Input: root1 = [1], root2 = [1,2]
        Output: [2,2]

    Constraints:
        The number of nodes in both trees is in the range [0, 2000].
        -104 <= Node.val <= 104
     */


    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     *This method uses depth first search to merge two trees together creating a tree with values that are the sum of both
     * trees by recursively call itself until it reaches the end of a branch on one of the two trees, once one of the
     * branches has reached an end, the merged tree is able to use the node of the other tree as it's merged
     * node which will allow it to obtain all child nodes of that node. If the nodes of two trees are not null, it will sum
     * the value up of the two nodes and continue searching until it finds an end on one or both of the two trees.
     * @param root1 root node of the firs tree
     * @param root2 root node of the second tree
     * @return the root of the merged tree;
     */

    public static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null)
            return root2;
        if (root2 == null)
            return root1;
        else {
            return dfs(root1, root2);
        }
    }

    private static TreeNode dfs(TreeNode first, TreeNode second) {
        //find end of the tree
        //base case:
        if (first == null)
            return second;
        else if (second == null)
            return first;
        else


        //Not at end of tree must continue looking
        return new TreeNode(first.val+second.val, dfs(first.left, second.left), dfs(first.right, second.right));
    }
    private static void test(TreeNode inputRoot1, TreeNode inputRoot2, TreeNode expected) {
        System.out.println("First tree: ");
        printTree(inputRoot1);

        System.out.println("Second tree: ");
        printTree(inputRoot2);

        TreeNode actual = mergeTrees(inputRoot1, inputRoot2);
        System.out.println("Merged tree: ");
        printTree(actual);
        System.out.println("Expected tree: ");
        printTree(expected);
    }

    private static void printTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        StringBuilder sb = new StringBuilder("[");
        while (queue.size() > 0) {
            TreeNode currentNode = queue.poll();

            if (currentNode != null)
                sb.append(currentNode.val + ", ");
            if (currentNode.left != null)
                queue.add(currentNode.left);
            if (currentNode.right != null)
                queue.add(currentNode.right);
        }
        sb.replace(sb.lastIndexOf(", "), sb.lastIndexOf(", ")+1, "]");

        System.out.println(sb.toString());
    }

    public static void main(String[]args) {
        TreeNode inputRoot1 = new TreeNode(1,
                new TreeNode(3,
                        new TreeNode(5),
                        null),
                new TreeNode(2));
        TreeNode inputRoot2 = new TreeNode(2,
                new TreeNode(1,
                        null,
                        new TreeNode(4)),
                new TreeNode(3,
                        null,
                        new TreeNode(7)));
        TreeNode expected = new TreeNode(3,
                new TreeNode(4,
                        new TreeNode(5),
                        new TreeNode(4)),
                new TreeNode(5,
                        null,
                        new TreeNode(7)));
        test(inputRoot1, inputRoot2, expected);
    }
}
