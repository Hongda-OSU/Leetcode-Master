class Solution {
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        List<int[]> edges = new ArrayList<>(n + 1 + pipes.length);
        for (int i = 0; i < n; i++)
            edges.add(new int[]{0, i + 1, wells[i]});
        for (int i = 0; i < pipes.length; i++) {
            int[] edge = pipes[i];
            edges.add(edge);
        }
        Collections.sort(edges, (a, b) -> a[2] - b[2]);
        UnionFind uf = new UnionFind(n);
        int totalCost = 0;
        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            int cost = edge[2];
            if (uf.union(x, y))
                totalCost += cost;
        }
        return totalCost;
    }
}

class UnionFind {
    public int[] group, rank;
    
    public UnionFind(int size) {
        group = new int[size + 1];
        rank = new int[size + 1];
        for (int i = 0; i < size + 1; i++) {
            group[i] = i;
            rank[i] = 0;
        }
    }
    
    public boolean union(int x, int y) {
        int f1 = find(x), f2 = find(y);
        if (f1 == f2)
            return false;
        if (rank[f1] > rank[f2])
            group[f2] = f1;
        else if (rank[f1] < rank[f2])
            group[f1] = f2;
        else {
            group[f1] = f2;
            rank[f2]++;
        }
        return true;
    }
    
    public int find(int x) {
        if (group[x] != x) 
            group[x] = find(group[x]);
        return group[x];
    }
}