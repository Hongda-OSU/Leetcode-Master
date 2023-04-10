class MyCalendar {
    public Node root;

    public MyCalendar() {
        this.root = null;
    }
    
    public boolean book(int start, int end) {
        if (root == null) {
            root = new Node(start, end);
            return true;
        } else {
            return insert(root, start, end);
        }
    }
    
    public boolean insert(Node node, int start, int end) {
        if (node.start >= end) {
            if (node.left == null) {
                node.left = new Node(start, end);
                return true;
            } else {
                return insert(node.left, start, end);
            }
        } else if (node.end <= start) {
            if (node.right == null) {
                node.right = new Node(start, end);
                return true;
            } else {
                return insert(node.right, start, end);
            }
        }
        return false;
    }
}

class Node {
    public int start, end;
    public Node left, right;
    
    public Node(int start, int end) {
        this.start = start;
        this.end = end;
        left = null;
        right = null;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */