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
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        return dfs(root1, root2, target);
    }
    
    private boolean dfs(TreeNode root1, TreeNode root2, int target) {
        if (root1 == null) 
            return false;
        if (root2 == null)
            return false;
        if (bst(root2, target - root1.val))
            return true;
        return dfs(root1.left, root2, target) || dfs(root1.right, root2, target);
    }
    
    private boolean bst(TreeNode root, int target) {
        if (root == null)
            return false;
        if (root.val == target)
            return true;
        else if (root.val > target)
            return bst(root.left, target);
        else 
            return bst(root.right, target);
    }
}