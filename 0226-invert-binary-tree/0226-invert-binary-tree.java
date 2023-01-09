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
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        invert(root);
        return root;
    }
    
    public void invert(TreeNode root) {
        TreeNode leftNode = null, rightNode = null;
        if (root.left != null) {
            leftNode = root.left;
            invert(leftNode);
        }
        if (root.right != null) {
            rightNode = root.right;
            invert(rightNode);
        }
        root.left = rightNode;
        root.right = leftNode;
    }
}