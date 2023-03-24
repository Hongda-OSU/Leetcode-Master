/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node prev;
    
    public Node flatten(Node head) {
        if (head == null)
            return null;
        if (prev != null) {
            prev.next = head;
            head.prev = prev;
        }
        prev = head;
        Node next = head.next;
        flatten(head.child);
        head.child = null;
        flatten(next);
        return head;
    }
}