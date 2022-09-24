/**
 * This is the interface for the expression tree Node.
 * You should not remove it, and you can define some classes to implement it.
 */

abstract class Node {
    public abstract int evaluate();
};

class TreeNode extends Node {
    String val;
    TreeNode left;
    TreeNode right;
    TreeNode (String val) {
        this.val = val;
    }
    
    BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;
    BiFunction<Integer, Integer, Integer> sub = (a, b) -> a - b;
    BiFunction<Integer, Integer, Integer> mul = (a, b) -> a * b;
    BiFunction<Integer, Integer, Integer> div = (a, b) -> a / b;
    
    public int evaluate() {
        return dfs(this);
    }
    
    public int dfs(TreeNode t){
        // Must be string integer
        if (t.left == null && t.right == null) {
            return Integer.parseInt(t.val);
        }
        int left = dfs(t.left);
        int right = dfs(t.right);
        int result = 0;
        // Note: string use equals
        if (t.val.equals("+")) {
            result = add.apply(left, right);
        } else if (t.val.equals("-")) {
            result = sub.apply(left, right);
        } else if (t.val.equals("*")) {
            result = mul.apply(left, right);
        } else if (t.val.equals("/")) {
            result = div.apply(left, right);
        }
        return result;
    }

}


/**
 * This is the TreeBuilder class.
 * You can treat it as the driver code that takes the postinfix input 
 * and returns the expression tree represnting it as a Node.
 */

class TreeBuilder {
    Node buildTree(String[] postfix) {
        String operators = "+-*/";
        // Stack of all root node
        Stack<TreeNode> st = new Stack<TreeNode>();
        for (String s : postfix) {
            if (operators.contains(s)) {
                // Construct a subTree
                TreeNode root = new TreeNode(s);
                TreeNode rightNode = st.pop();
                TreeNode leftNode = st.pop();
                root.left = leftNode;
                root.right = rightNode;
                st.push(root);
            } else {
                st.push(new TreeNode(s));
            }
        }
        return st.pop();
    }
};


/**
 * Your TreeBuilder object will be instantiated and called as such:
 * TreeBuilder obj = new TreeBuilder();
 * Node expTree = obj.buildTree(postfix);
 * int ans = expTree.evaluate();
 */