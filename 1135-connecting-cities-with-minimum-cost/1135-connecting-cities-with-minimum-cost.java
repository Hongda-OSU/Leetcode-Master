class Solution {
    public int minimumCost(int n, int[][] connections) {
        UnionFind uf = new UnionFind(n);
        Arrays.sort(connections, (a, b) -> a[2] - b[2]);
        int result = 0;
        for (int[] connection : connections) {
            int x = connection[0], y = connection[1];
            if (uf.find(x) != uf.find(y)) {
                result += connection[2];
                uf.union(x, y);
            }
        }
        return uf.n == 1 ? result : -1;
    }
}

class UnionFind {
    public int[] parent;
    public int n;
    
    public UnionFind(int size) {
        n = size;
        parent = new int[size + 1];
        for (int i = 0; i <= size; i++) 
            parent[i] = i;
    }
    
    public void union(int x, int y) {
        int f1 = find(x), f2 = find(y);
        if (f1 != f2) {
            parent[f1] = f2;
            n--;
        }
    }
    
    public int find(int x) {
        if (parent[x] != x)
            parent[x] = find(parent[x]);
        return parent[x];
    }
}