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
  int max = 0;

  private int longestZigZag(TreeNode node, boolean isRight) {
    if (node == null) return 0;

    var l = longestZigZag(node.left, true);
    var r = longestZigZag(node.right, false);

    max = Math.max(max, 1 + (isRight ? l : r));

    return 1 + (isRight ? r : l);
  }

  public int longestZigZag(TreeNode root) {
    return Math.max(longestZigZag(root, true), max) - 1;
  }
}