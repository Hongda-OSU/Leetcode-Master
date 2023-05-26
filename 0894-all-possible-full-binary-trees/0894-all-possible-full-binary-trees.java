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
    public List<TreeNode> allPossibleFBT(int n) {
        if (n % 2 == 0) {
            return new ArrayList<>();
        }

        List<List<TreeNode>> dp = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            dp.add(new ArrayList<>());
        }
        
        dp.get(1).add(new TreeNode(0));
        for (int l = 3; l <= n; l += 2) {
            for (int i = 1; i < l - 1; i += 2) {
                int j = l - 1 - i;
                for (TreeNode left : dp.get(i)) {
                    for (TreeNode right : dp.get(j)) {
                        TreeNode root = new TreeNode(0);
                        root.left = left;
                        root.right = right;
                        dp.get(l).add(root);
                    }
                }
            }
        }
        return dp.get(n);
    }
}