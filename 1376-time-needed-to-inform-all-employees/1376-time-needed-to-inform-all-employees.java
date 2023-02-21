class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, dfs(i, manager, informTime, map));
        }
        return max;
    }
    
    public int dfs(int id, int[] manager, int[] informTime, HashMap<Integer, Integer> map) {
        if (manager[id] == -1)
            return 0;
        if (map.containsKey(id))
            return map.get(id);
        map.put(id, informTime[manager[id]] + dfs(manager[id], manager, informTime, map));
        return map.get(id);
    }
}