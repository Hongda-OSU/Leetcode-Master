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
        Stack<TreeNode> nextStack = new Stack<>();
        Stack<TreeNode> prevStack = new Stack<>();
        Set<TreeNode> visited = new HashSet<>();

        public BSTIterator(TreeNode root) {
            fillInNextStack(root);
        }

        public boolean hasNext() {
            return !nextStack.isEmpty();
        }

        public int next() {
            TreeNode node = nextStack.pop();
            if(!visited.contains(node) && node.right != null) {
                fillInNextStack(node.right);
            }
            visited.add(node);
            prevStack.push(node);
            return node.val;
        }

        public boolean hasPrev() {
            return !prevStack.isEmpty() && prevStack.size() > 1;
        }

        public int prev() {
            nextStack.push(prevStack.pop());
            return prevStack.peek().val;
        }

        private void fillInNextStack(TreeNode node) {
            while(node != null) {
                nextStack.push(node);
                node = node.left;
            }
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