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
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        LinkedList<Integer> result = new LinkedList<>();
        
        dfsInOrder(root, target, k, result);
        return result;
    }
    
    private void dfsInOrder(TreeNode root, double target, int k, LinkedList<Integer> result) {
        if (root == null)
            return;
        dfsInOrder(root.left, target, k, result);
        if (result.size() < k) {
            result.add(root.val);
        } else {
            double diff = Math.abs(root.val - target);
            double diffLeft = Math.abs(result.peekFirst() - target);
            double diffRight = Math.abs(result.peekLast() - target);
            if (diff < diffLeft) {
                result.removeFirst();
                result.add(root.val);
            } else if (diff < diffRight) {
                result.removeFirst();
                result.add(root.val);
            }
        }
        dfsInOrder(root.right, target, k, result);
    }
}