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
    int preorderIndex;
    Map<Integer, Integer> inorderIndexMap;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preorderIndex = 0;
        // build a hashmap to store value -> its index relations
        inorderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }
        return buildBinaryTree(preorder, 0, preorder.length - 1);
    }
    
    public TreeNode buildBinaryTree(int[] preorder, int left, int right) {
        // if there are no elements to construct the tree
        if (left > right) return null;
        // select the preorder_index element as the root and increment it
        int rootVal = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootVal);
        // build left and right subtree
        // excluding inorderIndexMap[rootValue] element because it's the root
        root.left = buildBinaryTree(preorder, left, inorderIndexMap.get(rootVal) - 1);
        root.right = buildBinaryTree(preorder, inorderIndexMap.get(rootVal) + 1, right);
        return root;
    }
}