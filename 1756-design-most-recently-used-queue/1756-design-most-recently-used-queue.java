class MRUQueue {
    class Node {
        int val;
        Node next;
        Node prev;
        
        public Node(int v) {
            val = v;
        }
    }
    
    private static int step = 50; // alternatively it could be Math.sqrt(n)
    Node[] skipNodes;
    Node head;
    int MRUQueueLength;
    
    public MRUQueue(int n) {
        MRUQueueLength = n;
        int m = n / step;
        skipNodes = new Node[m];
        head = new Node(0);
        Node cur = head;
        int idx = 0;
        int j = 1;
        for (int i = n; i > 0; i--, j++) {
            Node next = new Node(i);
            cur.next = next;
            next.prev = cur;
            if (j == step) {
                skipNodes[idx++] = next;
                j = 0;
            }
            cur = next;
        }
    }
    
    public int fetch(int k) {
        int index = 0;
        int nodeIndex = MRUQueueLength - k + 1; // our list has reverse order
        Node cur = head;
        while(nodeIndex >= step) {
            nodeIndex -= step;
            cur = skipNodes[index];
            skipNodes[index] = skipNodes[index].prev;
            index++;
        }
        
        while(nodeIndex > 0) {
            cur = cur.next;
            nodeIndex--;
        }
        
        // delete cur from Linked List
        if (cur.next != null) cur.next.prev = cur.prev;
        cur.prev.next = cur.next;
		// insert cur after the head
        cur.next = head.next;
        if (head.next != null) head.next.prev = cur;
        cur.prev = head;
        head.next = cur;
        
        return cur.val;
    }
}