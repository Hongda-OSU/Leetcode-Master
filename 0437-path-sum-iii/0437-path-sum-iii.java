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
    private int count = 0;
    private HashMap<Long, Integer> map = new HashMap();
    
    public int pathSum(TreeNode root, int targetSum) {
        preorder(root, targetSum, 0L);
        return count;
    }
    
    public void preorder(TreeNode node, int targetSum, long currentSum) {
        if (node == null) return;
        // current prefix sum
        currentSum += node.val;
        if (currentSum == targetSum) count++;
        // number of times the currentSum − targetSumm has occured already
        // determines the number of times a path with sum targetSum has occured upto the current node
        count += map.getOrDefault(currentSum - targetSum, 0);
        map.put(currentSum, map.getOrDefault(currentSum, 0) + 1);
        preorder(node.left, targetSum, currentSum);
        preorder(node.right, targetSum, currentSum);
        // remove the current sum from the hashmap
        // in order not to use it during 
        // the parallel subtree processing
        map.put(currentSum, map.get(currentSum) - 1);
    }
}