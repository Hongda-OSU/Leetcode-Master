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
    public boolean isValidBST(TreeNode root) {
        return validBST(root, null, null);
    }
    
    public boolean validBST(TreeNode root, Integer low, Integer high) {
        // Empty trees are valid BSTs.
        if (root == null) return true;
        // The current node's value must be between low and high.
        if ((low != null && low >= root.val) || (high != null && high <= root.val)) {
            return false;
        }
        // The left and right subtree must also be valid.
        return validBST(root.left, low, root.val) && validBST(root.right, root.val, high);
    }
}