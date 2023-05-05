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
    private int maxLength = 0;
    
    public int longestConsecutive(TreeNode root) {
        dfs(root);
        return maxLength;
    }
    
    private int dfs(TreeNode node) {
        if (node == null)
            return 0;
        int left = dfs(node.left) + 1;
        int right = dfs(node.right) + 1;
        if (node.left != null && node.val + 1 != node.left.val)
            left = 1;
        if (node.right != null && node.val + 1 != node.right.val)
            right = 1;
        int length = Math.max(left, right);
        maxLength = Math.max(maxLength, length);
        return length;
    }
}