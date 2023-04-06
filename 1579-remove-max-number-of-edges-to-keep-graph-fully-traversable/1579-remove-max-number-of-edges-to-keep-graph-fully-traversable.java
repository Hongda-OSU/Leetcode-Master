class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        int count1 = 0, count2 = 0, result = 0;
        UnionFind uf = new UnionFind(n + 1);
        for (int[] edge : edges) {
            if (edge[0] == 3) {
                if (uf.union(edge[1], edge[2])) {
                    count1++;
                    count2++;
                } else {
                    result++;
                }
            }
        }
        int[] parent = uf.parent.clone();
        for (int[] edge : edges) {
            if (edge[0] == 1) {
                if (uf.union(edge[1], edge[2]))
                    count1++;
                else
                    result++;
            }
        }
        uf.parent = parent;
        for (int[] edge : edges) {
            if (edge[0] == 2) {
                if (uf.union(edge[1], edge[2]))
                    count2++;
                else 
                    result++;
            }
        }
        return (count1 == n - 1 && count2 == n - 1) ? result : -1;
    }
}

class UnionFind {
    public int[] parent;
    
    public UnionFind(int n) {
        this.parent = new int[n];
        for (int i = 1; i < n; i++) 
            parent[i] = i;
    }
    
    public boolean union(int x, int y) {
        int f1 = find(x), f2 = find(y);
        if (f1 == f2) 
            return false;
        parent[f1] = f2;
        return true;
    }
    
    public int find(int x) {
        if (x != parent[x]) 
            parent[x] = find(parent[x]);
        return parent[x];
    }
}