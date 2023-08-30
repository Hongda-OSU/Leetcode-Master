/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Codec {
    class WrappableInt {
        private int value;
        
        public WrappableInt(int x) {
            this.value = x;
        }
        
        public int getValue() {
            return this.value;
        }
        
        public void increment() {
            this.value++;
        }
    }
    
    // Encodes a tree to a single string.
    public String serialize(Node root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }
    
    private void serializeHelper(Node root, StringBuilder sb) {
        if (root == null)
            return;
        sb.append((char)(root.val + '0'));
        sb.append((char)(root.children.size() + '0'));
        for (Node child : root.children)
            serializeHelper(child, sb);
    }
	
    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        if (data.isEmpty())
            return null;
        return deserializeHelper(data, new WrappableInt(0));
    }
    
    private Node deserializeHelper(String data, WrappableInt wi) {
        if (wi.getValue() == data.length())
            return null;
        Node node = new Node(data.charAt(wi.getValue()) - '0', new ArrayList<>());
        wi.increment();
        int numChildren = data.charAt(wi.getValue()) - '0';
        for (int i = 0; i < numChildren; i++) {
            wi.increment();
            node.children.add(deserializeHelper(data, wi));
        }
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));