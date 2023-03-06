class Solution {
    public List<Boolean> areConnected(int n, int threshold, int[][] queries) {
        List<Boolean> result = new ArrayList<>();
        UnionFind uf = new UnionFind(n);
        for (int i = threshold + 1; i <= n; i++) {
            int mul = 1;
            while (mul * i <= n) {
                uf.union(i, mul * i);
                mul++;
            }
        }
        for (int[] query : queries) 
            result.add((uf.find(query[0]) == uf.find(query[1])));
        return result;
    }
}

class UnionFind {
    public int[] parent, rank;
    
    public UnionFind(int size) {
        parent = new int[size + 1];
        rank = new int[size + 1];
        for (int i = 1; i <= size; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }
    
    public void union(int x, int y) {
        int f1 = find(x), f2 = find(y);
        if (rank[f1] > rank[f2]) {
            parent[f2] = f1;
            rank[f1] += rank[f2];
        } else {
            parent[f1] = f2;
            rank[f2] += rank[f1];
        }
    }
    
    public int find(int x) {
        if (parent[x] != x) 
            parent[x] = find(parent[x]);
        return parent[x];
    }
}