class LFUCache {
    public int capacity, minFrequency = 1;
    public HashMap<Integer, Node> keyNodeMap = new HashMap<>();
    public HashMap<Integer, NodeDLinkedList> freqNodeMap = new HashMap<>(); 

    public LFUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        Node node = keyNodeMap.get(key);
        if (node != null) {
            incrementFrequency(node);
            return node.val;
        } else {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if (capacity <= 0)
            return;
        if (keyNodeMap.containsKey(key)) {
            Node node = keyNodeMap.get(key);
            node.val = value;
            incrementFrequency(node);
            keyNodeMap.put(key, node);
        } else {
            Node node = new Node(key, value);
            if (keyNodeMap.size() == capacity) {
                Node last = freqNodeMap.get(minFrequency).removeLastNode();
                keyNodeMap.remove(last.key);
            }
            incrementFrequency(node);
            keyNodeMap.put(key, node);
            minFrequency = 1;
        }
    }
    
    public void incrementFrequency(Node node) {
        int oldFreq = node.frequency;
        if (freqNodeMap.containsKey(oldFreq)) {
            NodeDLinkedList oldDll = freqNodeMap.get(oldFreq);
            oldDll.remove(node);
            if (node.frequency == minFrequency && oldDll.length == 0)
                minFrequency++;
        }
        int newFreq = oldFreq + 1;
        node.frequency = newFreq;
        NodeDLinkedList newDll = freqNodeMap.getOrDefault(newFreq, new NodeDLinkedList());
        newDll.add(node);
        freqNodeMap.put(newFreq, newDll);
    }
}

class Node {
    public int key, val, frequency;
    public Node next, prev;
    
    public Node(int key, int val) {
        this.key = key;
        this.val = val;
        this.frequency = frequency;
    }
}

class NodeDLinkedList {
    public Node head, tail;
    int length;
    
    public void add(Node node) {
        node.prev = null;
        node.next = null;
        if (head == null) {
            head = node;
            tail = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }
        length++;
    }
    
    public void remove(Node node) {
        if (node == head) {
            if (node == tail) 
                tail = null;
            head = head.next;
        } else {
            node.prev.next = node.next;
            if (node == tail)
                tail = node.prev;
            else 
                node.next.prev = node.prev;
        }
        length--;
    }
    
    public Node removeLastNode() {
        Node tailNode = tail;
        if (tailNode != null)
            remove(tailNode);
        return tailNode;
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */