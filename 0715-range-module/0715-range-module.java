class RangeModule {
    private TreeNode root;

    public RangeModule() {
        
    }
    
    public void addRange(int left, int right) {
        root = addRangeHelper(root, left, right);
    }
    
    public boolean queryRange(int left, int right) {
        return queryRangeHelper(root, left, right);
    }
    
    public void removeRange(int left, int right) {
        root = removeRangeHelper(root, left, right);
    }
    
    private TreeNode addRangeHelper(TreeNode node, int start, int end) {
        if (start >= end) 
            return node;
        if (node == null)
            return new TreeNode(start, end);
        if (start >= node.end) 
            node.right = addRangeHelper(node.right, start, end);
        else if (end <= node.start) 
            node.left = addRangeHelper(node.left, start, end);
        else {
            node.left = addRangeHelper(node.left, start, node.start);
            node.right = addRangeHelper(node.right, node.end, end);
        }
        return node;
    }
    
    private boolean queryRangeHelper(TreeNode node, int start, int end) {
        if (start >= end)
            return true;
        if (node == null)
            return false;
        if (start >= node.end)
            return queryRangeHelper(node.right, start, end);
        else if (end <= node.start)
            return queryRangeHelper(node.left, start, end);
        else if ((start >= node.start) && (end <= node.end))
            return true;
        return queryRangeHelper(node.left, start, node.start) && queryRangeHelper(node.right, node.end, end);
    }
    
    private TreeNode removeRangeHelper(TreeNode node, int start, int end) {
        if (start >= end)
            return node;
        if (node == null)
            return null;
        if (start >= node.end)
            node.right = removeRangeHelper(node.right, start, end);
        else if (end <= node.start)
            node.left = removeRangeHelper(node.left, start, end);
        else {
            node.left = removeRangeHelper(node.left, start, node.start);
            node.right = removeRangeHelper(node.right, node.end, end);
            node.left = addRangeHelper(node.left, node.start, start);
            node.left = addRangeHelper(node.left, end, node.end);
            node = remove(node);
        }
        return node;
    }
    
    private TreeNode remove(TreeNode node) {
        if (node == null)
            return node;
        if (node.left == null)
            return node.right;
        TreeNode leftLargest = getLargest(node.left, node);
        leftLargest.left = node.left;
        leftLargest.right = node.right;
        return leftLargest;
    }
    
    private TreeNode getLargest(TreeNode node, TreeNode parent) {
        while (node.right != null) {
            parent = node;
            node = node.right;
        }
        if (node == parent.left)
            parent.left = node.left;
        if (node == parent.right)
            parent.right = node.left;
        node.left = null;
        return node;
    }
}

class TreeNode {
    public int start, end;
    public TreeNode left, right;
    
    public TreeNode(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

/**
 * Your RangeModule object will be instantiated and called as such:
 * RangeModule obj = new RangeModule();
 * obj.addRange(left,right);
 * boolean param_2 = obj.queryRange(left,right);
 * obj.removeRange(left,right);
 */