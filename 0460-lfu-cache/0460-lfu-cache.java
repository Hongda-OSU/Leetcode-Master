class LFUCache {
    public static class Node {
        public int key;
        public int value;
        public int freq;
        public Node before, after;

        public Node() {
        }

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.freq = 1;
        }

        public void remove() {
            this.before.after = after;
            this.after.before = before;
        }

        public void add(Node n) {
            this.before = n;
            this.after = n.after;
            n.after = this;
            this.after.before = this;
        }
    }

    public int cap;
    public int size;
    public int minFreq;
    Node[] map;
    Node[] freqmap;

    public LFUCache(int capacity) {
        this.cap = capacity;
        this.size = 0;
        this.minFreq = 1;
        this.map = new Node[100001];
        this.freqmap = new Node[20001];
    }

    public int get(int key) {
        Node n = map[key];
        if (n == null) {
            return -1;
        }
        update(key);
        return n.value;
    }

    public void put(int key, int value) {
        Node n = map[key];
        if (n == null) {
            if (cap == 0) {
                return;
            }
            ++size;
            if (size > cap) {
                Node head = freqmap[minFreq];
                Node lfu = head.before;
                lfu.remove();
                map[lfu.key] = null;
                if (head == head.after) {
                    freqmap[minFreq] = null;
                }
                --size;
            }
            n = new Node(key, value);
            map[key] = n;
            if (freqmap[1] == null) {
                Node head = new Node();
                head.before = head;
                head.after = head;
                freqmap[1] = head;
            }
            n.add(freqmap[1]);
            minFreq = 1;
        } else {
            n.value = value;
            update(key);
        }
    }

    public void update(int key) {
        Node n = map[key];
        n.remove();
        int freq = n.freq;
        if (freqmap[freq] == freqmap[freq].after) {
            freqmap[freq] = null;
            if (freq == minFreq) {
                ++minFreq;
                ;
            }
        }
        freq = ++n.freq;
        if (freqmap[freq] == null) {
            Node head = new Node();
            head.before = head;
            head.after = head;
            freqmap[freq] = head;
        }
        n.add(freqmap[freq]);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */