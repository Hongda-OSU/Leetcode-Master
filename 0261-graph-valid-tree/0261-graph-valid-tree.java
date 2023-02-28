class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : adj.get(node)) {
                if (map.get(node) == neighbor)
                    continue;
                if (map.containsKey(neighbor))
                    return false;
                queue.offer(neighbor);
                map.put(neighbor, node);
            }
        }
        return map.size() == n;
    }
}