class Solution {
    public int numSimilarGroups(String[] strs) {
        int size = strs.length;
        UnionFind uf = new UnionFind(size);
        int count = size;
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (isSimilar(strs[i], strs[j]) && uf.find(i) != uf.find(j)) {
                    count--;
                    uf.union(i, j);
                }
            }
        }
        return count;
    }
    
    public boolean isSimilar(String str1, String str2) {
        int diff = 0;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i))
                diff++;
        }
        return diff == 0 || diff == 2;
    }
}

class UnionFind {
    public int[] parent, rank;
    
    public UnionFind(int size) {
        parent = new int[size];
        for (int i = 0; i < size; i++)
            parent[i] = i;
        rank = new int[size];
    }
    
    public void union(int x, int y) {
        int f1 = find(x);
        int f2 = find(y);
        if (rank[f1] < rank[f2])
            parent[f1] = f2;
        else if (rank[f1] > rank[f2])
            parent[f2] = f1;
        else {
            parent[f2] = f1; 
            rank[f1]++;
        }   
    }
    
    public int find(int x) {
        if (parent[x] != x)
            parent[x] = find(parent[x]);
        return parent[x];
    }
}