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
    public List<Integer> getLonelyNodes(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper(root, null, result);
        return result;
    }
    
    public void helper(TreeNode root, TreeNode parent, List<Integer> result) {
        if (root == null)
            return;
        if (parent != null && (parent.left == null || parent.right == null))
            result.add(root.val);
        helper(root.left, root, result);
        helper(root.right, root, result);
    }
}