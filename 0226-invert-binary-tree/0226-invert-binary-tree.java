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
    
    public void invert(TreeNode node) {
        TreeNode leftNode = null, rightNode = null;
        if (node.left != null) {
            leftNode = node.left;
            invert(leftNode);
        }
        if (node.right != null) {
            rightNode = node.right;
            invert(rightNode);
        }
        node.left = rightNode;
        node.right = leftNode;
    }
}