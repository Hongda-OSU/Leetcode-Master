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
    int sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        // head is not left
        sumLeft(root, false);
        return sum;
    }
    
    public void sumLeft(TreeNode node, boolean isLeft) {
        if (node == null) return;
        if (node.left == null && node.right == null) {
            if (isLeft)
                sum += node.val;
        }
        sumLeft(node.left, true);
        sumLeft(node.right, false);
    } 
}