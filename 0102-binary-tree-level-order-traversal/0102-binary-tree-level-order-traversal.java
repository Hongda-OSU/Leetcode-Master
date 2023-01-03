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
        if (root != null) traverseInLevelOrder(root, result, 0);
        return result;
    }
    
    public void traverseInLevelOrder(TreeNode node, List<List<Integer>> result, int level) {
        if (result.size() == level) result.add(new ArrayList<Integer>());
        result.get(level).add(node.val);
        level++;
        if (node.left != null) traverseInLevelOrder(node.left, result, level);
        if (node.right != null) traverseInLevelOrder(node.right, result, level);
    }
}