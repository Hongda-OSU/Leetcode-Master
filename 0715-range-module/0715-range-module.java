class RangeModule {

    public RangeModule() {
        
    }
    TreeNode root;
    
    class TreeNode
    {
        int start;
        int end;
        TreeNode right;
        TreeNode left;
        public TreeNode(int start,int end)
        {
            this.start=start;
            this.end=end;
        }
    }
    public void addRange(int left, int right) {
        root=addRange(root,left,right);
    }
    
    public boolean queryRange(int left, int right) {
        return queryRange(root,left,right);
    }
    
    public void removeRange(int left, int right) {
        root=removeRange(root,left,right);
    }
    public TreeNode removeRange(TreeNode root,int start, int end) {
       if(start>=end)
       return root;
       if(root==null)
       return null;
       if(start>=root.end)
       root.right=removeRange(root.right,start,end);
       else if(end<=root.start)
        root.left=removeRange(root.left,start,end);
        else
        {
        root.left=removeRange(root.left,start,root.start);
        root.right=removeRange(root.right,root.end,end);
        root.left=addRange(root.left,root.start,start);
        root.left=addRange(root.left,end,root.end);
        root=remove(root);
        }
        return root;


    }
    public TreeNode remove(TreeNode node)
    {
        if(node==null)
        return node;
        if(node.left==null)
        return node.right;
        TreeNode leftLargest=getLargest(node.left,node);
        leftLargest.left=node.left;
        leftLargest.right=node.right;
        return leftLargest;
    }
    public TreeNode getLargest(TreeNode node,TreeNode parent )
{
    while(node.right!=null)
    {
        parent=node;
        node=node.right;
    }
    if(node==parent.left)
    parent.left=node.left;
    if(node==parent.right)
    parent.right=node.left;
    node.left=null;
    return node;
}    
public TreeNode addRange(TreeNode root,int start, int end) {
    if(start>=end)
    return root;
    if(root==null)
    return new TreeNode(start,end);
    if(start>=root.end)
    root.right=addRange(root.right,start,end);
     else if(end<=root.start)
    root.left=addRange(root.left,start,end);
    else
    {
    root.left=addRange(root.left,start,root.start);
    root.right=addRange(root.right,root.end,end);
    }
    return root;
}
public boolean queryRange(TreeNode root,int start, int end) {
    if(start>=end)
    return true;
    if(root==null)
    return false;
    if(start>=root.end)
   return queryRange(root.right,start,end);
     else if(end<=root.start)
    return queryRange(root.left,start,end);
    else if((start>=root.start)&&(end<=root.end))
    return true;

    return queryRange(root.left,start,root.start) &&
           queryRange(root.right,root.end,end);
    
   
}
}

/**
 * Your RangeModule object will be instantiated and called as such:
 * RangeModule obj = new RangeModule();
 * obj.addRange(left,right);
 * boolean param_2 = obj.queryRange(left,right);
 * obj.removeRange(left,right);
 */