/**
 * Definition for a binary tree node.
 * class Node {
 *     char val;
 *     Node left;
 *     Node right;
 *     Node() {this.val = ' ';}
 *     Node(char val) { this.val = val; }
 *     Node(char val, Node left, Node right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public Node expTree(String s) {
        Deque<Character> deque = new LinkedList<>();
        for (char ch : s.toCharArray())
            deque.offerLast(ch);
        return helper(deque);
    }
    
    private Node helper(Deque<Character> deque) {
        Deque<Node> operands = new LinkedList<>();
        Deque<Node> operators = new LinkedList<>();
        while (!deque.isEmpty()) {
            char ch = deque.pollFirst();
            if (Character.isDigit(ch))
                operands.offerLast(new Node(ch));
            else if (ch == '(')
                operands.offerLast(helper(deque));
            else if (ch == ')') {
                eliminate(operands, operators);
                return operands.pollLast();
            } else {
                if (!operators.isEmpty() && !(((operators.peekLast().val == '+' || operators.peekLast().val == '-') && (ch == '*' || ch == '/'))))
                    eliminate(operands, operators);
                operators.offerLast(new Node(ch));
            }
        }
        eliminate(operands, operators);
        return operands.pollLast();
    }
    
    private void eliminate(Deque<Node> operands, Deque<Node> operators) {
        while (operands.size() != 1) {
            Node right = operands.pollLast();
            Node left = operands.pollLast();
            Node operator = operators.pollLast();
            operator.left = left;
            operator.right = right;
            operands.offerLast(operator);
        }
    }
}