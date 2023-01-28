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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        findPathSum(root, targetSum, path, result);
        return result;
    }
    
    public void findPathSum(TreeNode node, int sum, List<Integer> path, List<List<Integer>> result) {
        if (node == null) return;
        path.add(node.val);
        // if the current node is a leaf and its value is equal to sum, save the current path
        if (node.val == sum && node.left == null && node.right == null) {
            result.add(new ArrayList<>(path));
        } else {
            findPathSum(node.left, sum - node.val, path, result);
            findPathSum(node.right, sum - node.val, path, result);
        }
        // remove the current node from the path to backtrack, 
        // we need to remove the current node while we are going up the recursive call stack.
        path.remove(path.size() - 1);
    }
}