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
    private int minDiff = Integer.MAX_VALUE;
    private TreeNode prev;
    
    public int getMinimumDifference(TreeNode root) {
        inorder(root);
        return minDiff;
    }
    
    private void inorder(TreeNode node) {
        if (node == null)
            return;
        inorder(node.left);
        if (prev != null)
            minDiff = Math.min(minDiff, node.val - prev.val);
        prev = node;
        inorder(node.right);
    }
}