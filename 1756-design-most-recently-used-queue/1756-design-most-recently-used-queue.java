class ListNode {
    int val;
    ListNode next;

    ListNode() {

    }

    ListNode(int val) { 
        this.val = val; 
    }
}

class MRUQueue {
    ListNode head, tail;
    public MRUQueue(int n) {
        head = new ListNode();
        
        ListNode node = head;
        for(int i = 0; i <= n; i++) {
            node.next = new ListNode(i);
            node = node.next;
        }
        
        tail = node;
    }
    
    public int fetch(int k) {
        ListNode node = head;
        for(int i = 0; i <= k-1; i++) {
            node = node.next;
        }
        
        int val = node.next.val;
        
        tail.next = node.next;
        
        tail = tail.next;
        
        node.next = tail.next;
        
        tail.next = null;
        
        return val;
    }
}