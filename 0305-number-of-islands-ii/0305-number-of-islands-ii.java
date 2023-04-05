class Solution {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> result = new ArrayList<>();
        if (m == 0 || n == 0 || positions == null || positions.length == 0 || positions[0].length == 0)
            return result;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        UnionFind uf = new UnionFind(m * n);
        int count = 0;
        for (int[] position : positions) {
            int x = position[0], y = position[1];
            int p = x * n + y;
            if (uf.parent[p] != -1) {
                result.add(count);
                continue;
            }
            uf.parent[p] = p;
            count++;
            for (int[] dir : dirs) {
                int r = x + dir[0], c = y + dir[1];
                if (isValid(uf, m, n, r, c)) {
                    int q = r * n + c;
                    if (uf.union(p, q)) 
                        count--;
                }
            }
            result.add(count);
        }
        return result;
    }
    
    private boolean isValid(UnionFind uf, int m, int n, int r, int c) {
        if (r < 0 || c < 0 || r >= m || c >= n || uf.parent[r * n + c] == -1) {
            return false;
        }
        return true;
    }
}

class UnionFind {
    public int[] parent, rank;
    
    public UnionFind(int n) {
        this.parent = new int[n];
        this.rank = new int[n];
        Arrays.fill(parent, -1);
    }
    
    public boolean union(int p, int q) {
        int f1 = find(p), f2 = find(q);
        if (f1 == f2)
            return false;
        if (rank[f1] < rank[f2]) 
            parent[f1] = f2;
        else if (rank[f1] > rank[f2])
            parent[f2] = f1;
        else {
            parent[f2] = f1;
            rank[f1]++;
        }
        return true;
    }
    
    public int find(int x) {
        while (x != parent[x]) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }
}