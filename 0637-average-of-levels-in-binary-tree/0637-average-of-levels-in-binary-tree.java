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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Integer> count = new ArrayList<>();
        List<Double> result = new ArrayList<>();
        average(root, 0, result, count);
        for (int i = 0; i < result.size(); i++)
            result.set(i, result.get(i) / count.get(i));
        return result;
    }
    
    private void average(TreeNode node, int i, List<Double> list, List<Integer> count) {
        if (node == null)
            return;
        if (i < list.size()) {
            list.set(i, list.get(i) + node.val);
            count.set(i, count.get(i) + 1);
        } else {
            list.add(1.0 * node.val);
            count.add(1);
        }
        average(node.left, i + 1, list, count);
        average(node.right, i + 1, list, count);
    }
}