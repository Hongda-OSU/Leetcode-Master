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
    private int max = 0;
    
    public int longestZigZag(TreeNode root) {
        return Math.max(zigZagHelper(root, true), max) - 1;
    }
    
    private int zigZagHelper(TreeNode node, boolean isRight) {
        if (node == null)
            return 0;
        int left = zigZagHelper(node.left, true), right = zigZagHelper(node.right, false);
        max = Math.max(max, 1 + (isRight ? left : right));
        return 1 + (isRight ? right : left);
    }
}