class Solution {
    public int[] countPairs(int n, int[][] edges, int[] queries) {
        int[] count = new int[n + 1], sorted  = new int[n + 1], result = new int[queries.length];
        HashMap<Integer, Integer>[] shared = new HashMap[n + 1];
        for (int[] edge : edges) {
            sorted[edge[0]] = count[edge[0]] = count[edge[0]] + 1;
            sorted[edge[1]] = count[edge[1]] = count[edge[1]] + 1;
            int n1 = Math.min(edge[0], edge[1]), n2 = Math.max(edge[0], edge[1]);
            shared[n1] = shared[n1] == null ? new HashMap<>() : shared[n1];
            shared[n1].put(n2, shared[n1].getOrDefault(n2, 0) + 1);
        } 
        Arrays.sort(sorted);
        for (int k = 0; k < queries.length; k++) {
            for (int i = 1, j = n; i < j;) {
                if (queries[k] < sorted[i] + sorted[j])
                    result[k] += (j--) - i;
                else
                    i++;
            }
            for (int i = 1; i <= n; i++) {
                if (shared[i] != null) {
                    for (Map.Entry<Integer, Integer> entry : shared[i].entrySet()) {
                        int key = entry.getKey(), value = entry.getValue();
                        if (queries[k] < count[i] + count[key] && queries[k] + value >= count[i] + count[key])
                            result[k]--;
                    }
                }
            }
        }
        return result;
    }
}