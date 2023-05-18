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
    private int index;
    private int[] postorder, inorder;
    private HashMap<Integer, Integer> indexMap = new HashMap<>();
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.postorder = postorder;
        this.inorder = inorder;
        index = postorder.length - 1;
        int idx = 0;
        for (Integer i : inorder) 
            indexMap.put(i, idx++);
        return helper(0, inorder.length - 1);
    }
    
    private TreeNode helper(int left, int right) {
        if (left > right)
            return null;
        int rootVal = postorder[index];
        TreeNode root = new TreeNode(rootVal);
        int idx = indexMap.get(rootVal);
        index--;
        root.right = helper(idx + 1, right);
        root.left = helper(left, idx - 1);
        return root;
    }
} 