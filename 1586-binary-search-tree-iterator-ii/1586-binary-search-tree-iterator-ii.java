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

    // stack holds unvisited nodes
    Stack<TreeNode> stack;
    // list holds all visited nodes
    List<TreeNode> popedNodes;
    // always point to the latest visited node
    int ptr;
    public BSTIterator(TreeNode root) {
        stack = new Stack();
        popedNodes = new ArrayList();
        ptr = -1;
        
        while(root != null) {
            stack.push(root);
            root = root.left;
        }
    }
    
    public boolean hasNext() {
        // pre() was invoked
        if (ptr < popedNodes.size()-1 && popedNodes.size() > 0)
            return true;
        // prev points to end of list
        return !stack.isEmpty();
    }
    
    public int next() {
        if (ptr < popedNodes.size()-1) {
            return popedNodes.get(++ptr).val;
        }
        
        if (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            TreeNode curRight = cur.right;
            while (curRight != null) {
                stack.push(curRight);
                curRight = curRight.left;
            }
            popedNodes.add(cur);
            ptr = popedNodes.size()-1;
            return cur.val;
        }
        
        return popedNodes.get(0).val;
    }
    
    public boolean hasPrev() {
        return ptr > 0;
    }
    
    public int prev() {
        if (hasPrev()) {
            return popedNodes.get(--ptr).val;
        }
        return -1;
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