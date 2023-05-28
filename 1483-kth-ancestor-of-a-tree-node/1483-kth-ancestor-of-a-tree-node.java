class TreeAncestor {

     
    List<Integer>[] tree;       
    List<List<Integer>> level;  // nodes in a level
    int[] dfn;            // dfs number
    int ndfn;             // dfs number starts wih 0
    int[] depth;          // depth of each node
    
    public TreeAncestor(int n, int[] parent) {
        tree = new List[n];
        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }
        level = new ArrayList<>();
        dfn = new int[n];
        ndfn = 0;
        depth = new int[n];
        
        for (int i = 1; i < n; i++) {      // build tree
            tree[parent[i]].add(i);
        }
        dfs(0, 0);
    }
    
    private void dfs(int n, int dep) {
        if (level.size() == dep) {
            level.add(new ArrayList<>());
        }
        dfn[n] = ndfn++;                              // mark dfs number
        depth[n] = dep;                               // save the depth  
        level.get(dep).add(n);                    // save nodes into level
        for (int child : tree[n]) {
            dfs(child, dep + 1);
        }
    }
    
    public int getKthAncestor(int node, int k) {
        int d = depth[node];
        if (d - k < 0) return -1;
        List<Integer> list = level.get(d - k);
        int left = 0, right = list.size();
        while (left < right) {                                       // binary search
            int mid = left + (right - left) / 2;               
            if (dfn[list.get(mid)] < dfn[node]) {        // find the first node larger than or equal to dfn[node]
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return list.get(left - 1);                             // anc
}
}
/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */