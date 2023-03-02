class LRUCache {
    public Map<Integer, Node> map;
    public Node head, tail;
    public int capacity;
    
    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            Node curr = map.get(key);
            delete(curr);
            moveToHead(curr);
            return curr.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node curr = map.get(key);
            curr.val = value;
            delete(curr);
            moveToHead(curr);
        } else if (map.size() < capacity) {
            map.put(key, new Node(key, value));
            moveToHead(map.get(key));
        } else {
            map.put(key, new Node(key, value));
            map.remove(tail.prev.key);
            delete(tail.prev);
            moveToHead(map.get(key));
        }
    }
    
    public void delete(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    public void moveToHead(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next = node;
        node.next.prev = node;
    }
} 

class Node {
    public int key, val;
    public Node next, prev;
    
    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */