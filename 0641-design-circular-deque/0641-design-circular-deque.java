class MyCircularDeque {
DoublyLinkedList head;
DoublyLinkedList tail;
int k;
int size;

/** Initialize your data structure here. Set the size of the deque to be k. */
public MyCircularDeque(int k) {
    head = new DoublyLinkedList(-1);
    tail = new DoublyLinkedList(-1);
    head.next = tail;
    tail.prev = head;
    this.k = k;
    this.size = size;
}

/** Adds an item at the front of Deque. Return true if the operation is successful. */
public boolean insertFront(int value) {
    if(size == k) return false;
    DoublyLinkedList temp = new DoublyLinkedList(value);
    DoublyLinkedList curr = head.next;
    head.next = temp;
    temp.prev = head;
    temp.next = curr;
    curr.prev = temp;
    size += 1;
    return true;
}

/** Adds an item at the rear of Deque. Return true if the operation is successful. */
public boolean insertLast(int value) {
    if(size == k) return false;
    DoublyLinkedList temp = new DoublyLinkedList(value);
    DoublyLinkedList curr = tail.prev;
    temp.next = tail;
    tail.prev = temp;
    curr.next = temp;
    temp.prev = curr;
    size += 1;
    return true;
    
}

/** Deletes an item from the front of Deque. Return true if the operation is successful. */
public boolean deleteFront() {
    if(size == 0) return false;

    DoublyLinkedList curr = head.next;
    head.next = curr.next;
    head.next.prev = head;
    size -= 1;
    return true;
}

/** Deletes an item from the rear of Deque. Return true if the operation is successful. */
public boolean deleteLast() {
    if(size == 0) return false;

    DoublyLinkedList curr = tail.prev;
    tail.prev = curr.prev;
    tail.prev.next= tail;
    size -= 1;
    return true;
}

/** Get the front item from the deque. */
public int getFront() {
    if(size == 0) return -1;
    
    return head.next.val;
    
}

/** Get the last item from the deque. */
public int getRear() {
    if(size == 0) return -1;
    return tail.prev.val;
}

/** Checks whether the circular deque is empty or not. */
public boolean isEmpty() {
    return size == 0;
}

/** Checks whether the circular deque is full or not. */
public boolean isFull() {
    return size == k;
}

class DoublyLinkedList{
    DoublyLinkedList prev;
    DoublyLinkedList next;
    int val;
    DoublyLinkedList(int val){
        this.val = val;
    }
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