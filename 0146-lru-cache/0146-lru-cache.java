class LRUCache {
    private LinkedNodeList list;
    private Map<Integer, Node> map;
    private Integer cap;

    public LRUCache(int capacity) {
        list = new LinkedNodeList();
        map = new HashMap<>();
        cap = capacity;
    }
    
    public int get(int key) {
        Node node = map.get(key);
        if (node == null)
            return -1;
        list.moveToHead(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        Node node = map.get(key);
        if (node != null) {
            list.moveToHead(node);
            node.val = value;
        } else {
            Node newNode = new Node(key, value);
            if (map.size() == cap) {
                Node tail = list.getTail();
                map.remove(tail.key);
                list.removeTail();
            }
            map.put(key, newNode);
            list.addToHead(newNode);
        }
    }
}

class LinkedNodeList {
    public Node head, tail;
    
    public LinkedNodeList() {
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }
    
    public void moveToHead(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        addToHead(node);
    }
    
    public void addToHead(Node node) {
        Node temp = head.next;
        head.next = node;
        node.next = temp;
        node.prev = head;
        temp.prev = node;
    }
    
    public void removeTail() {
        Node newTail = tail.prev.prev;
        newTail.next = tail;
        tail.prev = newTail;
    }
    
    public Node getTail() {
        return tail.prev;
    }
} 

class Node {
    public int key, val;
    public Node prev, next;
    
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