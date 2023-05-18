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
    private int index;
    private List<Integer> list;

    public BSTIterator(TreeNode root) {
        list = new ArrayList<>();
        index = -1;
        DLR(root, list);
    }
    
    private void DLR(TreeNode root, List<Integer> list) {
        if (root == null)
            return;
        DLR(root.left, list);
        list.add(root.val);
        DLR(root.right, list);
    }
    
    public boolean hasNext() {
        return index + 1 < list.size();
    }
    
    public int next() {
        index++;
        return list.get(index);
    }
    
    public boolean hasPrev() {
        return index - 1 >= 0;
    }
    
    public int prev() {
        index--;
        return list.get(index);
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * boolean param_1 = obj.hasNext();
 * int param_2 = obj.next();
 * boolean param_3 = obj.hasPrev();
 * int param_4 = obj.prev();
 */