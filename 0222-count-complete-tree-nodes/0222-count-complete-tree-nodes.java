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
    public int countNodes(TreeNode root) {
        if (root == null)
            return 0;
        int depth = treeDepth(root);
        if (depth == 0) 
            return 1;
        int left = 1, right = (int)Math.pow(2, depth) - 1;
        while (left <= right) {
            int pivot = (left + right) >>> 1;
            if (exists(pivot, depth, root))
                left = pivot + 1;
            else
                right = pivot - 1;
        }
        return (int)Math.pow(2, depth) - 1 + left;
    }
    
    public int treeDepth(TreeNode node) {
        int depth = 0;
        while (node.left != null) {
            node = node.left;
            depth++;
        }
        return depth;
    }
    
    public boolean exists(int p, int depth, TreeNode node) {
        int left = 0, right = (int)Math.pow(2, depth) - 1;
        for (int i = 0; i < depth; i++) {
            int pivot = (left + right) >>> 1;
            if (p <= pivot) {
                node = node.left;
                right = pivot;
            } else {
                node = node.right;
                left = pivot + 1;
            }
        }
        return node != null;
    }
}