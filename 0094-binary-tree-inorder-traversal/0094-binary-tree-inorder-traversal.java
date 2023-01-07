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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root != null) inorder(root, result);
        return result;
    }
    
    public void inorder(TreeNode root, List<Integer> result) {
        if (root.left != null) inorder(root.left, result);
        result.add(root.val);
        if (root.right != null) inorder(root.right, result);
    }
}