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
        private Deque<TreeNode> stack = new ArrayDeque<>();
        private List<TreeNode> list = new ArrayList<>();
        private int curIndex = -1;
        // curIndex is the cur element tht we are standing on
        // curIndex- 1 is the prev value; curIndex+1 is the next value, if exists, in the list
        // if curIndex+1 is too big we expand the list by adding the top of the stack to it and move nextIndex

        private void pushLeft(TreeNode p) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
        }

        private boolean inRange(int i) {
            return i >= 0 && i < list.size();
        }

        public BSTIterator(TreeNode root) {
            pushLeft(root);
        }

        public boolean hasNext() {
            if (inRange(curIndex + 1)) {
                return true;
            }
            return !stack.isEmpty();
        }

        public int next() {
            int rt = 0;
            if (inRange(curIndex + 1)) {
                rt = list.get(curIndex + 1).val;
            } else {
                // if cur node is the last we will have to expand
                TreeNode next = stack.pop();
                pushLeft(next.right);
                list.add(next);
                rt = next.val;
            }
            curIndex++;
            return rt;
        }

        public boolean hasPrev() {
            return inRange(curIndex - 1);
        }

        public int prev() {
            return list.get(--curIndex).val;
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