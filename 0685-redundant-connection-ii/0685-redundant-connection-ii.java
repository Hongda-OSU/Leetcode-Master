class Solution {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int[] indegree = new int[edges.length + 1];
        Arrays.fill(indegree, -1);
        int p1 = -1, p2 = -1;
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0], v = edges[i][1];
            if (indegree[v] == -1) {
                indegree[v] = i;
            } else {
                p1 = i;
                p2 = indegree[v];
                break;
            }
        }
        int[] parent = new int[edges.length + 1];
        int[] rank = new int[edges.length + 1];
        for (int i = 0; i < parent.length; i++) 
            parent[i] = i;
        for (int i = 0; i < edges.length; i++) {
            if (i == p1)
                continue;
            int[] edge = edges[i];
            if (union(edge[0], edge[1], parent, rank)) {
                if (p1 == -1)
                    return edge;
                else 
                    return edges[p2];
            }
        }
        return edges[p1];
    }
    
    public boolean union(int s1, int s2, int[] parent, int[] rank) {
        int f1 = find(s1, parent), f2 = find(s2, parent);
        if (f1 != f2) {
            if (rank[f1] > rank[f2]) 
                parent[f2] = f1;
            else if (rank[f2] > rank[f1])
                parent[f1] = f2;
            else {
                parent[f2] = f1;
                rank[f1]++;
            }
            return false;
        } 
        return true;
    }  
    
    public int find(int x, int[] parent) {
        if (x == parent[x]) 
            return x;
        else 
            return find(parent[x], parent);
    }
}