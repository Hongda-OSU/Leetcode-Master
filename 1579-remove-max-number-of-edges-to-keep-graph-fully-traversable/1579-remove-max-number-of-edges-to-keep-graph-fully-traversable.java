class UF {
    int[] parent;
    
    public UF(int n) {
        parent = new int[n];
        for (int i = 1; i < n; i++) {
            parent[i] = i;
        }
    }
    
    public boolean union(int x, int y) {
        int px = find(x);
        int py = find(y);
        if (px == py) {
            return false;
        }
        parent[px] = py;
        return true;
    }
    
    private int find(int x) {
        return parent[x] = x == parent[x] ? x : find(parent[x]);
    }
}

class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        int cnt1 = 0;
        int cnt2 = 0;
        int res = 0;
        UF uf = new UF(n + 1);
        for (int[] edge : edges) {
            if (edge[0] == 3) {
                if (uf.union(edge[1], edge[2])) {
                    cnt1++;
                    cnt2++;
                }
                else {
                    res++;
                }
            }
        }
        int[] parentcpy = uf.parent.clone();
        for (int[] edge : edges) {
            if (edge[0] == 1) {
                if (uf.union(edge[1], edge[2])) {
                    cnt1++;
                }
                else {
                    res++;
                }
            }
        }
        uf.parent = parentcpy;
        for (int[] edge : edges) {
            if (edge[0] == 2) {
                if (uf.union(edge[1], edge[2])) {
                    cnt2++;
                }
                else {
                    res++;
                }
            }
        }
        return cnt1 == n - 1 && cnt2 == n - 1 ? res : -1;
    }
}