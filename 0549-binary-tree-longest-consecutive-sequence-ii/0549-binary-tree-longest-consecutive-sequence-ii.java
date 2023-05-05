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
    private int maxVal = 0;
    
    public int longestConsecutive(TreeNode root) {
        longestPath(root);
        return maxVal;
    }
    
    private int[] longestPath(TreeNode node) {
        if (node == null)
            return new int[]{0, 0};
        int increase = 1, decrease = 1;
        if (node.left != null) {
            int[] left = longestPath(node.left);
            if (node.val == node.left.val + 1)
                decrease = left[1] + 1;
            else if (node.val == node.left.val - 1)
                increase = left[0] + 1;
        }
        if (node.right != null) {
            int[] right = longestPath(node.right);
            if (node.val == node.right.val + 1)
                decrease = Math.max(decrease, right[1] + 1);
            else if (node.val == node.right.val - 1)
                increase = Math.max(increase, right[0] + 1);
        }
        maxVal = Math.max(maxVal, decrease + increase - 1);
        return new int[] {increase, decrease};
    }
}