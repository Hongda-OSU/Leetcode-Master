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
class Solution {
    public int largestBSTSubtree(TreeNode root) {
        return helper(root).size;
    }
    
    private Node helper(TreeNode root) {
        if (root == null)
            return new Node(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        Node left = helper(root.left);
        Node right = helper(root.right);
        if (left.max < root.val && root.val < right.min)
            return new Node(Math.min(root.val, left.min), Math.max(root.val, right.max), left.size + right.size + 1);
        return new Node(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left.size, right.size));
    }
}

class Node {
    public int min, max, size;
    
    public Node(int min, int max, int size) {
        this.min = min;
        this.max = max;
        this.size = size;
    }
}