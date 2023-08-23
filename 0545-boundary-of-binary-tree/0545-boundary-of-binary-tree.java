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
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        result.add(root.val);
        formLeftBoundary(root.left, result);
        addLeaves(root.left, result);
        addLeaves(root.right, result);
        formRightBoundary(root.right, result);
        return result;
    }
    
    private void formLeftBoundary(TreeNode node, List<Integer> list) {
        if (node == null)
            return;
        if (node.left != null) {
            list.add(node.val);
            formLeftBoundary(node.left, list);
        } else if (node.right != null) {
            list.add(node.val);
            formLeftBoundary(node.right, list);
        }
    }
    
    private void formRightBoundary(TreeNode node, List<Integer> list) {
        if (node == null)
            return;
        if (node.right != null) {
            formRightBoundary(node.right, list);
            list.add(node.val);
        } else if (node.left != null) {
            formRightBoundary(node.left, list);
            list.add(node.val);
        }
    }
    
    private void addLeaves(TreeNode node, List<Integer> list) {
        if (node == null)
            return;
        addLeaves(node.left, list);
        if (node.left == null && node.right == null)
            list.add(node.val);
        addLeaves(node.right, list);
    }
}