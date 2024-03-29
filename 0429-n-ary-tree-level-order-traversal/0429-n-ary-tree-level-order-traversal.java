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

class Solution {
    private List<List<Integer>> result = new ArrayList<>();
    
    public List<List<Integer>> levelOrder(Node root) {
        if (root != null)
            traverseNode(root, 0);
        return result;
    }
    
    private void traverseNode(Node node, int level) {
        if (result.size() <= level)
            result.add(new ArrayList<>());
        result.get(level).add(node.val);
        for (Node child : node.children)
            traverseNode(child, level + 1);
    }
}