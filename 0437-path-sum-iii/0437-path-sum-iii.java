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
    private int count = 0;
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;
        getSum(root, targetSum, 0);
        pathSum(root.left, targetSum);
        pathSum(root.right, targetSum);
        return count;
    }
    
    public void getSum(TreeNode root, int targetSum, long currentSum) {
        if (root == null) return;
        currentSum += root.val;
        if (currentSum == targetSum)
            count++;
        getSum(root.left, targetSum, currentSum);
        getSum(root.right, targetSum, currentSum);
    }
}