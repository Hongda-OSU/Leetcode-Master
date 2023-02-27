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
    public int widthOfBinaryTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> index = new LinkedList<>();
        queue.add(root);
        index.add(1);
        int width = 0;
        while (!queue.isEmpty()) {
            int n = queue.size(), start = 0, end = 0;
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                int idx = index.poll();
                if (i == 0)
                    start = idx;
                if (i == n - 1)
                    end = idx;
                if (node.left != null) {
                    queue.add(node.left);
                    index.add(idx * 2);
                }
                if (node.right != null) {
                    queue.add(node.right);
                    index.add(idx * 2 + 1);
                }
            }
            width = Math.max(width, end - start + 1);
        }
        return width;
    }
}