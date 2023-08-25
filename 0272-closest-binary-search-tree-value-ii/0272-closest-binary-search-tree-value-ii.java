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
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        Queue<Integer> heap = new PriorityQueue<>((a, b) -> Math.abs(a - target) > Math.abs(b - target) ? -1: 1);
        dfs(root, heap, k);
        
        return new ArrayList<>(heap);
    }
    
    public void dfs(TreeNode node, Queue<Integer> heap, int k) {
        if (node == null) {
            return;
        }
        
        heap.add(node.val);
        if (heap.size() > k) {
            heap.remove();
        }
        
        dfs(node.left, heap, k);
        dfs(node.right, heap, k);
    }
}