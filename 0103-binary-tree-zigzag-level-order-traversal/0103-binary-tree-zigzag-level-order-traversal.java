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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) 
            return result;
        dfs(root, 0, result);
        return result;
    }
    
    public void dfs(TreeNode node, int level, List<List<Integer>> result) {
        if (level >= result.size()) {
            LinkedList<Integer> newLevel = new LinkedList<>();
            newLevel.add(node.val);
            result.add(newLevel);
        } else {
            if (level % 2 == 0)
                result.get(level).add(node.val);
            else
                result.get(level).add(0, node.val);
        }
        if (node.left != null) dfs(node.left, level + 1, result);
        if (node.right != null) dfs(node.right, level + 1, result);
    }
}