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
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildBST(nums, 0, nums.length - 1);
    }
    
    public TreeNode buildBST(int[]nums, int left, int right) {
        if (left > right) return null;
        int pivot = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[pivot]);
        root.left = buildBST(nums, left, pivot - 1);
        root.right = buildBST(nums, pivot + 1, right);
        return root;
    }
}