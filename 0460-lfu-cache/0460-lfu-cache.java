class LFUCache {
    public int cap, size, minFreq;
    public Node[] map, freqMap;

    public LFUCache(int capacity) {
        this.cap = capacity;
        this.size = 0;
        this.minFreq = 1;
        this.map = new Node[100001];
        this.freqMap = new Node[20001];
    }
    
    public int get(int key) {
        Node node = map[key];
        if (node == null)
            return -1;
        update(key);
        return node.value;
    }
    
    public void put(int key, int value) {
        Node node = map[key];
        if (node == null) {
            if (cap == 0)
                return;
            size += 1;
            if (size > cap) {
                Node head = freqMap[minFreq];
                Node lfu = head.prev;
                lfu.remove();
                map[lfu.key] = null;
                if (head == head.next)
                    freqMap[minFreq] = null;
                size -= 1;
            }
            node = new Node(key, value);
            map[key] = node;
            if (freqMap[1] == null) {
                Node head = new Node();
                head.prev = head;
                head.next = head;
                freqMap[1] = head;
            }
            node.add(freqMap[1]);
            minFreq = 1;
        } else {
            node.value = value;
            update(key);
        }
    }
    
    private void update(int key) {
        Node node = map[key];
        node.remove();
        int freq = node.freq;
        if (freqMap[freq] == freqMap[freq].next) {
            freqMap[freq] = null;
            if (freq == minFreq)
                minFreq += 1;
        }
        freq = ++node.freq;
        if (freqMap[freq] == null) {
            Node head = new Node();
            head.prev = head;
            head.next = head;
            freqMap[freq] = head;
        }
        node.add(freqMap[freq]);
    }
}

class Node {
    public int key, value, freq;
    public Node prev, next;
    
    public Node() {   
    }
    
    public Node(int key, int value) {
        this.key = key;
        this.value = value;
        this.freq = 1;
    }
    
    public void remove() {
        this.prev.next = next;
        this.next.prev = prev;
    }
    
    public void add(Node node) {
        this.prev = node;
        this.next = node.next;
        node.next = this;
        this.next.prev = this;
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */