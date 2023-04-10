class MRUQueue {
    public Node[] nodes;
    public int bucket;

    public MRUQueue(int n) {
        bucket = (int)Math.sqrt(n);
        nodes = new Node[(n + bucket - 1) / bucket];
        Arrays.asList(nodes).replaceAll(i -> new Node(-1));
        for (int i = 1; i <= n; i++)
            nodes[(i - 1) / bucket].prev.append(new Node(i));
    }
    
    public int fetch(int k) {
        k -= 1;
        Node result = nodes[k / bucket].next;
        for (int i = k % bucket; i > 0; i--) 
            result = result.next;
        result.remove();
        for (int i = 1 + k / bucket; i < nodes.length; i++)
            nodes[i - 1].prev.append(nodes[i].next.remove());
        nodes[nodes.length - 1].prev.append(result);
        return result.val;
    }
}

class Node {
    public Node prev, next;
    public int val;
    
    public Node(int val) {
        this.val = val;
        prev = this;
        next = this;
    }
    
    public void append(Node node) {
        Node temp = next;
        next = node;
        node.prev = this;
        node.next = temp;
        temp.prev = node;
    }
    
    public Node remove() {
        prev.next = next;
        next.prev = prev;
        return next = prev = this;
    }
}

/**
 * Your MRUQueue object will be instantiated and called as such:
 * MRUQueue obj = new MRUQueue(n);
 * int param_1 = obj.fetch(k);
 */