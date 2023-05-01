class MyLinkedList {
    private Node head, tail;
    private int length;

    public MyLinkedList() {
        length = 0;
    }
    
    public int get(int index) {
        Node result = getNodeByIndex(index);
        if (result != null)
            return result.val;
        return -1;
    }
    
    public void addAtHead(int val) {
        if (length > 0) {
            Node temp = head;
            head = new Node(val);
            head.next = temp;
            temp.prev = head;
        } else {
            head = new Node(val);
            tail = head;
        }
        length++;
    }
    
    public void addAtTail(int val) {
        if (length > 0) {
            Node temp = tail;
            tail = new Node(val);
            tail.prev = temp;
            temp.next = tail;
        } else {
            tail = new Node(val);
            head = tail;
        }
        length++;
    }
    
    public void addAtIndex(int index, int val) {
        if (index < 0 || index > length)
            return;
        if (index == 0)
            addAtHead(val);
        else if (index == length)
            addAtTail(val);
        else {
            Node result = getNodeByIndex(index);
            if (result != null) {
                Node temp = new Node(val);
                temp.prev = result.prev;
                result.prev.next = temp;
                temp.next = result;
                result.prev = temp;
                length++;
            }
        }
    }
    
    public void deleteAtIndex(int index) {
        if (index < 0 || index > length)
            return;
        if (index == 0) {
            if (length == 1) {
                head = null;
                tail = null;
            } else {
                head = head.next;
                if (length > 2)
                    head.next.prev = head;
            }
            length--;
        } else if (index == length - 1) {
            tail = tail.prev;
            if (length > 2)
                tail.prev.next = tail;
            length--;
        } else {
            Node result = getNodeByIndex(index);
            if (result != null) {
                result.prev.next = result.next;
                result.next.prev = result.prev;
                length--;
            }
        }
    }
    
    private Node getNodeByIndex(int index) {
        if (length > 0 && index < length) {
            if (index == 0)
                return head;
            if (index == length - 1)
                return tail;
            Node result;
            if (index > length / 2) {
                result = tail;
                for (int i = length - 1; i > index; i--) 
                    result = result.prev;
            } else {
                result = head;
                for (int i = 1; i <= index; i++) 
                    result = result.next;
            }
            return result;
        }
        return null;
    }
}

class Node {
    public int val;
    public Node next, prev;
    
    public Node(int val) {
        this.val = val;
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