/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    TreeNode ancestor;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int parentVal = root.val, pVal = p.val, qVal = q.val;
        if (pVal > parentVal && qVal > parentVal) lowestCommonAncestor(root.right, p, q);
        else if (pVal < parentVal && qVal < parentVal) lowestCommonAncestor(root.left, p, q);
        else ancestor = root;
        return ancestor;
    }
}