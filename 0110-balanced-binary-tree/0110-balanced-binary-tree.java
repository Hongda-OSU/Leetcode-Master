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
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return height(root) != -1;
    }
    
    public int height(TreeNode root) {
        if (root == null) return 0;
        int left = height(root.left);
        int right = height(root.right);
        // In case of left subtree or right subtree unbalanced, return -1...
        if (left == -1 || right == -1) return -1;
        // If their heights differ by more than ‘1’, return -1...
        if (Math.abs(left - right) > 1) return -1;
        // Otherwise, return the height of this subtree as max(leftHeight, rightHight) + 1...
        return Math.max(left, right) + 1;
    }
}