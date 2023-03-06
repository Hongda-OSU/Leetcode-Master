class Solution {
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        UnionFind uf = new UnionFind(n);
        int size = queries.length;
        boolean[] result = new boolean[size];
        int[][] queriesWithIndex = new int[size][4];
        for (int i = 0; i < size; i++) {
            queriesWithIndex[i][0] = queries[i][0];
            queriesWithIndex[i][1] = queries[i][1];
            queriesWithIndex[i][2] = queries[i][2];
            queriesWithIndex[i][3] = i;
        }
        Arrays.sort(edgeList, (a, b) -> a[2] - b[2]);
        Arrays.sort(queriesWithIndex, (a, b) -> a[2] - b[2]);
        int edgeIndex = 0;
        for (int queryIndex = 0; queryIndex < size; queryIndex++) {
            int p = queriesWithIndex[queryIndex][0];
            int q = queriesWithIndex[queryIndex][1];
            int limit = queriesWithIndex[queryIndex][2];
            int idx = queriesWithIndex[queryIndex][3];
            while (edgeIndex < edgeList.length && edgeList[edgeIndex][2] < limit) {
                int x = edgeList[edgeIndex][0];
                int y = edgeList[edgeIndex][1];
                uf.union(x, y);
                edgeIndex++;
            }
            result[idx] = uf.connected(p, q);
        }
        return result;
    }
}

class UnionFind {
    public int[] parent, rank;
    
    public UnionFind(int size) {
        parent = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++)
            parent[i] = i;
    }
    
    public void union(int x, int y) {
        int f1 = find(x), f2 = find(y);
        if (f1 == f2)
            return;
        if (rank[f1] > rank[f2]) 
            parent[f2] = f1;
        else if (rank[f1] < rank[f2])
            parent[f1] = f2;
        else {
            parent[f1] = f2;
            rank[f2]++;
        }
    }
    
    public int find(int x) {
        if (parent[x] != x) 
            parent[x] = find(parent[x]);
        return parent[x];
    }
    
    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }
}