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

// Encodes a tree to a single string.
public String serialize(Node root) {
    StringBuilder sb = new StringBuilder();
    serialize(root, sb);
    return sb.toString();
}
 
private void serialize(Node root, StringBuilder sb){
    if(root == null) {
      sb.append("#").append(",");   
    }else{
        sb.append(root.val).append(",");
        sb.append(root.children.size()).append(",");
        for(Node child : root.children){
            serialize(child, sb);
        }
    }      
}
// Decodes your encoded data to tree.
public Node deserialize(String data) {
    Queue<String> q = new LinkedList<>(Arrays.asList(data.split(",")));
    return deserialize(q);
}
private Node deserialize(Queue<String> q){
    String s = q.poll();
    if(s.equals("#")) return null;
    
    Node root = new Node(Integer.valueOf(s));
    int children = Integer.valueOf(q.poll());
    
    root.children = new ArrayList<>();
    for(int i=0; i< children; i++){
        root.children.add(deserialize(q));
    }
    return root;
}
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));