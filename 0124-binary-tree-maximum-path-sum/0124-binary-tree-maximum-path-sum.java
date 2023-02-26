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
    private int sum = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        maxSum(root);
        return sum;
    }
    
    public int maxSum(TreeNode root) {
        if (root == null)
            return 0;
        int leftMax = Math.max(0, maxSum(root.left));
        int rightMax = Math.max(0, maxSum(root.right));
        sum = Math.max(sum, root.val + leftMax + rightMax);
        return root.val + Math.max(leftMax, rightMax);
    }
}