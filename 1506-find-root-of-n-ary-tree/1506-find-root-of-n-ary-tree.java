/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    
    public Node() {
        children = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        children = new ArrayList<Node>();
    }
    
    public Node(int _val,ArrayList<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public Node findRoot(List<Node> tree) {
        // set that contains all the child nodes.
        HashSet<Integer> seen = new HashSet<Integer>();

        // add all the child nodes into the set
        for (Node node : tree) {
            for (Node child : node.children)
                // we could either add the value or the node itself.
                seen.add(child.val);
        }

        Node root = null;
        // find the node that is not in the child node set.
        for (Node node : tree) {
            if (!seen.contains(node.val)) {
                root = node;
                break;
            }
        }
        return root;
    }
}