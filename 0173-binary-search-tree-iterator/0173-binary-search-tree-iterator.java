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
public class BSTIterator {
    private TreeNode node;
    private Stack<TreeNode> stack;
    
    public BSTIterator(TreeNode root) {
        node = root;
        stack = new Stack();
    }

    public boolean hasNext() {
        return node != null || !stack.empty();
    }

    public int next() {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
        TreeNode next = stack.pop();
        node = next.right;
        return next.val;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */