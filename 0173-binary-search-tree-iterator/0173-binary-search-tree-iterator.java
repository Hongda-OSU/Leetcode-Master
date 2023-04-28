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
class BSTIterator {
    private ArrayList<Integer> nodesSorted;
    private int index;

    public BSTIterator(TreeNode root) {
        nodesSorted = new ArrayList<>();
        index = -1;
        inorder(root);
    }
    
    private void inorder(TreeNode root) {
        if (root == null)
            return;
        inorder(root.left);
        nodesSorted.add(root.val);
        inorder(root.right);
    }
    
    public int next() {
        return nodesSorted.get(++index);
    }
    
    public boolean hasNext() {
        return index + 1 < nodesSorted.size();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */