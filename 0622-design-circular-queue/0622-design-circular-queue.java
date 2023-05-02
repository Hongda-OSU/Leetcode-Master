class MyCircularQueue {
    private int[] arr;
    private int front, rear, size;

    public MyCircularQueue(int k) {
        arr = new int[k];
        front = 0;
        rear = -1;
        size = k;
    }
    
    public boolean enQueue(int value) {
        if (isFull())
            return false;
        if (rear == size - 1)
            rear = -1;
        arr[++rear] = value;
        return true;
    }
    
    public boolean deQueue() {
        if (isEmpty())
            return false;
        if (front == rear) {
            front = 0;
            rear = -1;
        } else {
            if (front == size - 1)
                front = 0;
            else
                front++;
        }
        return true;
    }
    
    public int Front() {
        if (isEmpty())
            return -1;
        return arr[front];
    }
    
    public int Rear() {
        if (isEmpty())
            return -1;
        return arr[rear];
    }
    
    public boolean isEmpty() {
        return front == 0 && rear == -1;
    }
    
    public boolean isFull() {
        if (front == 0 && rear == size - 1)
            return true;
        if (front != 0 && rear == front - 1)
            return true;
        return false;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */