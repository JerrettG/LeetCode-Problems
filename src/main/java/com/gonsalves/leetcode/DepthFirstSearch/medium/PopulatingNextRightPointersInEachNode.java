package com.gonsalves.leetcode.DepthFirstSearch.medium;

public class PopulatingNextRightPointersInEachNode {
    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    /**
     * This method uses depth-first search in order to connect the nodes of the tree to the right node in the current level.
     * It is able to accomplish this by starting at the root node and doing the assigning the left node's next to the right node,
     * and it assigns the right node's next pointer to the next of the current node. The current node's next on the first iteration
     * is null, which makes the right node's next pointer null, however, on the second level traversal, the node is able to connect
     * its right node to the left node of the right branch since the current node's next pointer has been assigned to the right
     * branch's node.
     *                           1
     *                       /      \
     *                      v        v
     *                     2    ->    3
     *                   /  \        /  \
     *                 v     v      v    v
     *                4  ->  5  ->  6  -> 7
     * @param root The root of the tree we are connecting nodes for
     * @return the root of the tree that we connected nodes for
     */
    public Node connect(Node root) {
        dfs(root);
        return root;
    }

    private void dfs(Node root) {
        //base case:
        if (root == null || root.left == null || root.right == null)
            return;

        //recursive case
        root.left.next = root.right;
        if (root.next != null)
            root.right.next = root.next.left;
        else
            root.right.next = root.next;
        dfs(root.left);
        dfs(root.right);

    }

    public static void main(String[] args) {

    }
}
