class Solution {
    public int deleteTreeNodes(int nodes, int[] parent, int[] value) {
        Map<Integer, Set<Integer>> tree = new HashMap<>();
        for (int i = 0; i < nodes; i++) {
            tree.computeIfAbsent(parent[i], s -> new HashSet<>()).add(i);
        }
        return dfs(0, tree, value)[1];
    }
    
    private int[] dfs(int x, Map<Integer, Set<Integer>> tree, int[] value) {
        int total = value[x], count = 1;
        if (tree.containsKey(x)) {
            for (int child : tree.get(x)) {
                int[] next = dfs(child, tree, value);
                total += next[0];
                count += next[1];
            }
        }
        return new int[]{total, total == 0 ? 0 : count};
    }
}