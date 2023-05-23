/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
};
*/

class Solution {
    public Node construct(int[][] grid) {
        return helper(grid, 0, 0, grid.length);
    }
    
    private Node helper(int[][] grid, int x1, int y1, int length) {
        if (same(grid, x1, y1, length))
            return new Node(grid[x1][y1] == 1,  true);
        else {
            Node root = new Node(false, false);
            root.topLeft = helper(grid, x1, y1, length / 2);
            root.topRight = helper(grid, x1, y1 + length / 2, length / 2);
            root.bottomLeft = helper(grid, x1 + length / 2, y1, length / 2);
            root.bottomRight = helper(grid, x1 + length / 2, y1 + length / 2, length / 2);
            return root;
        }
    }
    
    private boolean same(int[][] grid, int x1, int y1, int length) {
        for (int i = x1; i < x1 + length; i++) {
            for (int j = y1; j < y1 + length; j++) {
                if (grid[i][j] != grid[x1][y1])
                    return false;
            }
        }
        return true;
    }
}