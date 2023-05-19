/**
 * This is the interface for the expression tree Node.
 * You should not remove it, and you can define some classes to implement it.
 */

abstract class Node {
    public abstract int evaluate();
    // define your fields here
};

class TreeNode extends Node {
    public String val;
    public TreeNode left, right;
    
    public TreeNode(String str) {
        this.val = str;
    }
    
    public int evaluate() {
        return dfs(this);
    }
    
    private int dfs(TreeNode root) {
        if (root.left == null && root.right == null) 
            return Integer.valueOf(root.val);
        int left = dfs(root.left), right = dfs(root.right), result = 0;
        String oper = root.val;
        if (oper.equals("+"))
            result = left + right;
        else if (oper.equals("-"))
            result = left - right;
        else if (oper.equals("*"))
            result = left * right;
        else 
            result = left / right;
        return result;
    }
}


/**
 * This is the TreeBuilder class.
 * You can treat it as the driver code that takes the postinfix input 
 * and returns the expression tree represnting it as a Node.
 */

class TreeBuilder {
    public String operators = "+-*/";
    public Stack<TreeNode> stack = new Stack<>();
    
    Node buildTree(String[] postfix) {
        for (String str : postfix) {
            if (operators.contains(str)) {
                TreeNode curr = new TreeNode(str);
                curr.right = stack.pop();
                curr.left = stack.pop();
                stack.push(curr);
            } else {
                stack.push(new TreeNode(str));
            }
        }
        return stack.pop();
    }
};


/**
 * Your TreeBuilder object will be instantiated and called as such:
 * TreeBuilder obj = new TreeBuilder();
 * Node expTree = obj.buildTree(postfix);
 * int ans = expTree.evaluate();
 */