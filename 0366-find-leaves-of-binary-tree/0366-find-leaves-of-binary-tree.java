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
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        height(root, result);
        return result;
    }
    
    public int height(TreeNode node, List<List<Integer>> result) {
        if (node == null)
            return -1;
        int level = 1 + Math.max(height(node.left, result), height(node.right, result));
        if (result.size() < level + 1)
            result.add(new ArrayList<>());
        result.get(level).add(node.val);
        return level;
    }
}