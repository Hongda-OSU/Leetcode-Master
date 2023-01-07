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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root != null) preorder(root, result);
        return result;
    }
    
    public void preorder(TreeNode root, List<Integer> result) {
        result.add(root.val);
        if (root.left != null) preorder(root.left, result);
        if (root.right != null) preorder(root.right, result);
    }
}