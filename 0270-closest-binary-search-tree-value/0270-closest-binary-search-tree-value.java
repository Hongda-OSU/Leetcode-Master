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
    public int closestValue(TreeNode root, double target) {
        int a = root.val;
        if (a == target)
            return a;
        TreeNode node = a < target ? root.right : root.left;
        if (node == null)
            return a;
        int b = closestValue(node, target);
        return Math.abs(a - target) < Math.abs(b - target) ? a : b;
    }
}