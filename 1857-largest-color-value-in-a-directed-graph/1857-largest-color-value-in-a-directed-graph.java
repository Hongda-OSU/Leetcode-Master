class Solution {
    public int max;
    public Map<Integer, Map<Character, Integer>> memo;
    public boolean hasCycle;
    
    public int largestPathValue(String colors, int[][] edges) {
        // using dfs
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
            List<Integer> list = map.getOrDefault(edge[0], new ArrayList<>());
            list.add(edge[1]);
            map.put(edge[0], list);
        }
        max = -1;
        memo = new HashMap<>();
        boolean[] visited = new boolean[colors.length()];
        hasCycle = false;
        for (int i = 0; i < colors.length(); i++) {
            dfs(i, map, colors, visited);
            if (hasCycle)
                return -1;
        }
        return max;
    }
    
    public Map<Character, Integer> dfs(int idx, Map<Integer, List<Integer>> map, String colors, boolean[] visited) {
        if (visited[idx]) {
            hasCycle = true;
            return new HashMap<>();
        }
        if (memo.get(idx) != null) 
            return memo.get(idx);
        visited[idx] = true;
        List<Integer> list = map.get(idx);
        Map<Character, Integer> currMap = new HashMap<>();
        if (list != null && !list.isEmpty()) {
            for (int i : list) {
                Map<Character, Integer> resMap = dfs(i, map, colors, visited);
                if (hasCycle)
                    return currMap;
                for (char ch : resMap.keySet()) {
                    int value = resMap.get(ch);
                    int currValue = currMap.getOrDefault(ch, 0);
                    currValue = Math.max(currValue, value);
                    currMap.put(ch, currValue);
                    max = Math.max(currValue, max);
                }
            }
        }
        int currNodeColorCount = currMap.getOrDefault(colors.charAt(idx), 0);
        currMap.put(colors.charAt(idx), currNodeColorCount + 1);
        max = Math.max(currNodeColorCount + 1, max);
        visited[idx] = false;
        memo.put(idx, currMap);
        return currMap;
    } 
}