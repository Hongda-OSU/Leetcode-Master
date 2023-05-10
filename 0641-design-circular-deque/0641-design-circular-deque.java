class MyCircularDeque {
    private DoublyLinkedList head, tail;
    private int k, size;

    public MyCircularDeque(int k) {
        head = new DoublyLinkedList(-1);
        tail = new DoublyLinkedList(-1);
        head.next = tail;
        tail.prev = head;
        this.k = k;
        this.size = size;
    }
    
    public boolean insertFront(int value) {
        if (size == k)
            return false;
        DoublyLinkedList temp = new DoublyLinkedList(value);
        DoublyLinkedList curr = head.next;
        head.next = temp;
        temp.prev = head;
        temp.next = curr;
        curr.prev = temp;
        size++;
        return true;
    }
    
    public boolean insertLast(int value) {
        if (size == k)
            return false;
        DoublyLinkedList temp = new DoublyLinkedList(value);
        DoublyLinkedList curr = tail.prev;
        temp.next = tail;
        tail.prev = temp;
        curr.next = temp;
        temp.prev = curr;
        size++;
        return true;
    }
    
    public boolean deleteFront() {
        if (size == 0)
            return false;
        DoublyLinkedList curr = head.next;
        head.next = curr.next;
        head.next.prev = head;
        size--;
        return true;
    }
    
    public boolean deleteLast() {
        if (size == 0)
            return false;
        DoublyLinkedList curr = tail.prev;
        tail.prev = curr.prev;
        tail.prev.next = tail;
        size--;
        return true;
    }
    
    public int getFront() {
        if (size == 0)
            return -1;
        return head.next.val;
    }
    
    public int getRear() {
        if (size == 0)
            return -1;
        return tail.prev.val;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == k;
    }
}

class DoublyLinkedList {
    public DoublyLinkedList next, prev;
    public int val;
    
    public DoublyLinkedList(int val) {
        this.val = val;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */