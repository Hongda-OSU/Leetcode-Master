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
    private Deque<TreeNode> stack;
    private List<Integer> list;
    private TreeNode last;
    private int pointer;

    public BSTIterator(TreeNode root) {
        last = root;
        stack = new ArrayDeque<>();
        list = new ArrayList<>();
        pointer = -1;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty() || last != null || pointer < list.size() - 1;
    }
    
    public int next() {
        pointer += 1;
        if (pointer == list.size()) {
            while (last != null) {
                stack.push(last);
                last = last.left;
            }
            TreeNode curr = stack.pop();
            last = curr.right;
            list.add(curr.val);
        }
        return list.get(pointer);
    }
    
    public boolean hasPrev() {
        return pointer > 0;
    }
    
    public int prev() {
        pointer -= 1;
        return list.get(pointer);
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