/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        Node dummy = new Node(0);
        dummy.next = root;
        // 'pre' will be the "current node" that builds every single layer   
        Node prev = dummy, head = root;
        while (root != null) {
            if (root.left != null) {
                prev.next = root.left;
                prev = prev.next;
            }
            if (root.right != null) {
                prev.next = root.right;
                prev = prev.next;
            }
            root = root.next;
            // reach the end of current layer
            if (root == null) {
                // shift prev back to the beginning, get ready to point to the first element in next layer  
                prev = dummy;
                // root comes down one level below to the first available non null node
                root = dummy.next;
                // reset dummyhead back to default null
                dummy.next = null;
            }
        }
        return head;
    }
}