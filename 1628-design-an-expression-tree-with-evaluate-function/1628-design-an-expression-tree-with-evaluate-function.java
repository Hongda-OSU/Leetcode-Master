/**
 * This is the interface for the expression tree Node.
 * You should not remove it, and you can define some classes to implement it.
 */

abstract class Node {
    public abstract int evaluate();
    // define your fields here
};

class NumNode extends Node {
    private int val;
    public NumNode(int val) {
        this.val = val;
    }
    public int evaluate() {
        return this.val;
    }
};

class OpNode extends Node {
    private char op;
    private Node left;
    private Node right;
    public OpNode(char op, Node left, Node right) {
        this.op = op;
        this.left = left;
        this.right = right;
    }
    public int evaluate() {
        switch(this.op) {
            case '+':
                return this.left.evaluate() + this.right.evaluate();
            case '-':
                return this.left.evaluate() - this.right.evaluate();
            case '*':
                return this.left.evaluate() * this.right.evaluate();
            case '/':
                return this.left.evaluate() / this.right.evaluate();
            default:
                return 0;
        }
    }
};

class TreeBuilder {
    Node buildTree(String[] postfix) {
        Stack<Node> st = new Stack<Node>();
        for (String s : postfix){
            if(Character.isDigit(s.charAt(0))){
                st.add(new NumNode(Integer.parseInt(s)));
            }else{
                Node right = st.pop();
                Node left = st.pop();
                st.add(new OpNode(s.charAt(0), left, right));
            }
        }
        return st.peek();
    }
};


/**
 * Your TreeBuilder object will be instantiated and called as such:
 * TreeBuilder obj = new TreeBuilder();
 * Node expTree = obj.buildTree(postfix);
 * int ans = expTree.evaluate();
 */