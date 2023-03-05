class Solution {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        int x[] = { -1, 1, 0, 0 };
        int y[] = { 0, 0, -1, 1 };
        UnionFind uf = new UnionFind(m * n);
        List<Integer> result = new ArrayList<>();
        for (int[] position : positions) {
            int landPos = position[0] * n + position[1];
            uf.addLand(landPos);
            for (int i = 0; i < 4; i++) {
                int neighborX = position[0] + x[i];
                int neighborY = position[1] + y[i];
                int neighborPos = neighborX * n + neighborY;
                if (neighborX >= 0 && neighborX < m && neighborY >= 0 && neighborY < n && uf.isLand(neighborPos))
                    uf.union(landPos, neighborPos);
            }
            result.add(uf.numLand());
        }
        return result;
    }
}

class UnionFind {
    public int[] parent, rank;
    public int count;
    
    public UnionFind(int size) {
        parent = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++)
            parent[i] = -1;
        count = 0;
    }
    
    public void union(int x, int y) {
        int f1 = find(x), f2 = find(y);
        if (f1 == f2)
            return;
        else if (rank[f1] < rank[f2])
            parent[f1] = f2;
        else if (rank[f1] > rank[f2])
            parent[f2] = f1;
        else  {
            parent[f2] = f1;
            rank[f1]++;
        }
        count--;
    }
    
    public int find(int x) {
        if (parent[x] != x)
            parent[x] = find(parent[x]);
        return parent[x];
    }
    
    public void addLand(int x) {
        if (parent[x] >= 0)
            return;
        parent[x] = x;
        count++;
    }
    
    public boolean isLand(int x) {
        if (parent[x] >= 0)
            return true;
        else
            return false;
    }
    
    public int numLand() {
        return count;
    }
}