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
    List<Integer> result = new ArrayList<>();
    Map<TreeNode, TreeNode> childParentMap = new HashMap<>();
    Set<TreeNode> visited = new HashSet<>();
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        findParent(root);
        dfs(target, k);
        return result;
    }
    
    private void findParent(TreeNode node) {
        if (node == null) 
            return;
        if (node.left != null) {
            childParentMap.put(node.left, node);
            findParent(node.left);
        }
         if (node.right != null) {
            childParentMap.put(node.right, node);
            findParent(node.right);
        } 
    }
    
    private void dfs(TreeNode node, int k) {
        if (node == null || visited.contains(node))
            return;
        visited.add(node);
        if (k == 0) {
            result.add(node.val);
            return;
        }
        dfs(node.left, k - 1);
        dfs(node.right, k - 1);
        dfs(childParentMap.get(node), k - 1);
    }
}