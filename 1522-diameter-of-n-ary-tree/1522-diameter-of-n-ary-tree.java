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
    public int diameter(Node root) {
        if (root == null || root.children.size() == 0)
            return 0;
        int[] maxDiameter = new int[1];
        diameterHelper(root, maxDiameter);
        return maxDiameter[0];
    }
    
    public int diameterHelper(Node root, int[] maxDiameter) {
        if (root == null)
            return 0;
        int maxHeight1 = 0, maxHeight2 = 0;
        for (Node child : root.children) {
            int childHeight = diameterHelper(child, maxDiameter);
            if (childHeight > maxHeight1) {
                maxHeight2 = maxHeight1;
                maxHeight1 = childHeight;
            } else if (childHeight > maxHeight2) {
                maxHeight2 = childHeight;
            }
        }
        maxDiameter[0] = Math.max(maxDiameter[0], maxHeight1 + maxHeight2);
        return maxHeight1 + 1;
    }
}