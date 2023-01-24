class MyLinkedList {
    
    class Node {
        Node next = null;
        int val = 0;
        
        public Node(int val) {
            this.val = val;
        }
    }
    
    private Node head;
    private Node tail;
    private int size;

    public MyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    
    public int get(int index) {
        if (index < 0 || index >= this.size)
            return -1;
        Node curr = this.head;
        while (index-- > 0)
            curr = curr.next;
        return curr.val;
    }
    
    public Node getNodeAt(int index) {
        Node curr = head;
        while (index-- > 0)
            curr = curr.next;
        return curr;
    }
    
    public void addAtHead(int val) {
        Node node = new Node(val);
        if (this.size == 0) {
            this.head = node;
            this.tail = node;
        } else {
            node.next = this.head;
            this.head = node;
        }
        this.size++;
    }
    
    public void addAtTail(int val) {
        Node node = new Node(val);
        if (this.size == 0) {
            this.head = node;
            this.tail = node;
        } else {
            this.tail.next = node;
            node.next = null;
            this.tail = node;
        }
        this.size++;
    }
    
    public void addAtIndex(int index, int val) {
        if (index < 0 || index > this.size) return;
        if (index == 0) {
            addAtHead(val); 
            return;
        }
        if (index == this.size) {
            addAtTail(val); 
            return;
        }
        Node prev = getNodeAt(index - 1);
        Node next = prev.next;
        Node curr = new Node(val);
        prev.next = curr;
        curr.next = next;
        this.size++;
    }
    
    public void deleteFirst() {
        if (this.size == 0) return;
        if (this.size == 1) {
            this.head = null;
            this.tail = null;
        } else {
            Node curr = this.head;
            Node next = curr.next;
            curr.next = null;
            this.head = next;
        }
        this.size--;
    }
    
    public void deleteLast() {
        if (this.size == 0) return;
        if (this.size == 1) {
            this.head = null;
            this.tail = null;
        } else {
            Node secondPrev = getNodeAt(this.size - 2);
            secondPrev.next = null;
            this.tail = secondPrev;
        }
        this.size--;
    }
    
    public void deleteAtIndex(int index) {
        if(index < 0 || index >= this.size) return;
        if(index == 0) {
            deleteFirst(); 
            return;
        }
        if(index == this.size - 1) {
            deleteLast(); 
            return;
        }
        Node prev = getNodeAt(index-1);
        Node curr = prev.next;
        Node next2 = prev.next.next;
        prev.next = next2;
        curr.next = null;
        this.size--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */