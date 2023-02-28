class Solution {
    private int[] group;
    
    public int[] findRedundantConnection(int[][] edges) {
        group = new int[edges.length + 1];
        for (int i = 0; i < group.length; i++)
            group[i] = i;
        for (int[] edge : edges) {
            if (find(edge[0]) == find(edge[1]))
                return edge;
            else 
                union(edge[0], edge[1]);
        }
        return edges[0];
    }
    
    public void union(int x, int y) {
        group[find(y)] = find(x);
    }
    
    public int find(int i) {
        if (i != group[i])
            group[i] = find(group[i]);
        return group[i];
    }
}