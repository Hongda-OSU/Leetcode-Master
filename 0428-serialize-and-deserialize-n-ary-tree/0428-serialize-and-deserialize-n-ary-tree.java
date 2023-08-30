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
        private Integer value;
        public WrappableInt(Integer x) {
            this.value = x;
        }
        public Integer getValue() {
            return this.value;
        }
        public void increment() {
            this.value++;
        }
    }
    
    // Was searching for typedef alternatives in Java and came across fake classes
    // Mostly considered an anti-pattern but it definitely makes our code much more
    // readable!
    class DeserializedObject extends HashMap<Integer, Pair<Integer, Pair<Integer, Node>>> {}
    
    
    // Encodes a tree to a single string.
    public String serialize(Node root) {
        
        StringBuilder sb = new StringBuilder();
        this._serializeHelper(root, sb, new WrappableInt(1), null);
        return sb.toString();
    }
    
    private void _serializeHelper(Node root, StringBuilder sb, WrappableInt identity, Integer parentId) {
        
        if (root == null) {
            return;
        }
        
        // Own identity
        sb.append((char) (identity.getValue() + '0'));
        
        // Actual value
        sb.append((char) (root.val + '0'));
        
        // Parent's identity
        sb.append((char) (parentId == null ? 'N' : parentId + '0'));
        
        parentId = identity.getValue();
        for (Node child : root.children) {
            identity.increment();
            this._serializeHelper(child, sb, identity, parentId);
        }
    }

    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        if(data.isEmpty())
            return null;
        
        return this._deserializeHelper(data);
    }
    
    private Node _deserializeHelper(String data) {  
        
        // HashMap explained in the algorithm
        DeserializedObject nodesAndParents = new DeserializedObject();
        
        // Constructing the hashmap using the input string
        for (int i = 0; i < data.length(); i+=3) {
            int id = data.charAt(i) - '0';
            int orgValue = data.charAt(i + 1) - '0';
            int parentId = data.charAt(i + 2) - '0';
            Pair<Integer, Pair<Integer, Node>> node = new Pair<Integer, Pair<Integer, Node>>(orgValue, 
                                           new Pair<Integer, Node>(parentId, 
                                           new Node(orgValue, new ArrayList<Node>())));
            nodesAndParents.put(id, node);
        }
        
        // A second pass for tying up the proper child connections
        for (int i = 3; i < data.length(); i+=3) {
            
            // Current node
            int id = data.charAt(i) - '0';
            Node node = nodesAndParents.get(id).getValue().getValue();
            
            // Parent node
            int parentId = data.charAt(i + 2) - '0';
            Node parentNode = nodesAndParents.get(parentId).getValue().getValue();
            
            // Attach!
            parentNode.children.add(node);
        }
        
        // Return the root node.
        return nodesAndParents.get(data.charAt(0) - '0').getValue().getValue();
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));