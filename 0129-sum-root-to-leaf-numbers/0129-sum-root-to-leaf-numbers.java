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
    private int rootToLeaf = 0;
    
    public int sumNumbers(TreeNode root) {
        preorder(root, 0);
        return rootToLeaf;
    }
    
    private void preorder(TreeNode node, int curr) {
        if (node != null) {
            curr = curr * 10 + node.val;
            if (node.left == null && node.right == null) 
                rootToLeaf += curr;
            preorder(node.left, curr);
            preorder(node.right, curr);
        }
    }
}