class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        Arrays.sort(edges, (a, b) -> b[0] - a[0]);
        int[] parentAlice = new int[n + 1];
        int[] parentBob = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            parentAlice[i] = i;
            parentBob[i] = i;
        }
        int mergeAlice = 1, mergeBob = 1, removeEdge = 0;
        for (int[] edge : edges) {
            int category = edge[0], u = edge[1], v = edge[2];
            if (category == 3) {
                boolean alice = union(u, v, parentAlice);
                boolean bob = union(u, v, parentBob);
                if (alice == true)
                    mergeAlice++;
                if (bob == true)
                    mergeBob++;
                if (alice == false && bob == false)
                    removeEdge++;
            } else if (category == 2) {
                boolean bob = union(u, v, parentBob);
                if (bob == true)
                    mergeBob++;
                else
                    removeEdge++;
            } else {
                boolean alice = union(u, v, parentAlice);
                if (alice == true)
                    mergeAlice++;
                else
                    removeEdge++;
            }
        }
        if (mergeAlice != n || mergeBob != n)
            return -1;
        return removeEdge;
    }
    
    public boolean union(int u, int v, int[] parent) {
        int fu = find(u, parent), fv = find(v, parent);
        if (fu != fv) {
            parent[fu] = fv;
            return true;
        } else 
            return false;
    }
    
    public int find(int i, int[] parent) {
        if (parent[i] == i)
            return i;
        int tmp = find(parent[i], parent);
        parent[i] = tmp;
        return tmp;
    }
}