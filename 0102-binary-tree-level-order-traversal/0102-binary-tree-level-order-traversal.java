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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root != null) levelOrderTraversal(root, result, 0);
        return result;
    }
    
    public void levelOrderTraversal(TreeNode root, List<List<Integer>> result, int level) {
        if (result.size() == level) result.add(new ArrayList<>());
        result.get(level).add(root.val);
        level++;
        if (root.left != null) levelOrderTraversal(root.left, result, level);
        if (root.right != null) levelOrderTraversal(root.right, result, level);
    }
}