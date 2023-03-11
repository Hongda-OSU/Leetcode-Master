class Solution {
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        List<Integer> criticals = new ArrayList<>();
        List<Integer> pseduos = new ArrayList<>();
        Map<int[], Integer> map = new HashMap<>();
        for (int i = 0; i < edges.length; i++) 
            map.put(edges[i], i);
        Arrays.sort(edges, (e1, e2) -> Integer.compare(e1[2], e2[2]));
        int minCost = buildMST(n, edges, null, null);
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            int idx = map.get(edge);
            int costWithout = buildMST(n, edges, null, edge);
            if (costWithout > minCost)
                criticals.add(idx);
            else {
                int costWith = buildMST(n, edges, edge, null);
                if (costWith == minCost)
                    pseduos.add(idx);
            }
        }
        return Arrays.asList(criticals, pseduos);
    }
    
    public int buildMST(int n, int[][] edges, int[] pick, int[] skip) {
        UnionFind uf = new UnionFind(n);
        int cost = 0;
        if (pick != null) {
            uf.union(pick[0], pick[1]);
            cost += pick[2];
        }
        for (int[] edge : edges) {
            if (edge != skip && uf.union(edge[0], edge[1]))
                cost += edge[2];
        }
        return uf.count == 1 ? cost : Integer.MAX_VALUE;
    }
}

class UnionFind {
    public int[] parent;
    public int count;
    
    public UnionFind(int size) {
        parent = new int[size];
        for (int i = 0; i < size; i++)
            parent[i] = i;
        count = size;
    }
    
    public boolean union(int x, int y) {
        int f1 = find(x), f2 = find(y);
        if (f1 != f2) {
            count--;
            parent[f1] = f2;
            return true;
        } else {
            return false;
        }
    }
    
    public int find(int x) {
        if (parent[x] != x)
            parent[x] = find(parent[x]);
        return parent[x];
    } 
}