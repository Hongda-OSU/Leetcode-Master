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
    private int min = 0, max = 0;
public List<List<Integer>> verticalOrder(TreeNode root) {
    List<List<Integer>> list = new ArrayList<>();
    if(root == null)    return list;
    computeRange(root, 0);
    for(int i = min; i <= max; i++) list.add(new ArrayList<>());
    Queue<TreeNode> q = new LinkedList<>();
    Queue<Integer> idx = new LinkedList<>();
    idx.add(-min);
    q.add(root);
    while(!q.isEmpty()){
        TreeNode node = q.poll();
        int i = idx.poll();
        list.get(i).add(node.val);
        if(node.left != null){
            q.add(node.left);
            idx.add(i - 1);
        }
        if(node.right != null){
            q.add(node.right);
            idx.add(i + 1);
        }
    }
    return list;
}
private void computeRange(TreeNode root, int idx){
    if(root == null)    return;
    min = Math.min(min, idx);
    max = Math.max(max, idx);
    computeRange(root.left, idx - 1);
    computeRange(root.right, idx + 1);
}
}