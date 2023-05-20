class Solution {
    public int shortestPathLength(int[][] graph) {
        int len = graph.length;
        if (len == 1)
            return 0;
        int target = (1 << len) - 1;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] dp = new boolean[len][target + 1];
        int covered = 0, minDegree= Integer.MAX_VALUE, firstIndex = -1;
        for (int[] arr : graph)
            minDegree = Math.min(minDegree, arr.length);
        for (int i = 0; i < graph.length; i++) {
            if (graph[i].length == minDegree)
                queue.add(new int[]{i, 1 << i});
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            covered++;
            while (size-- > 0) {
                int[] temp = queue.remove();
                int index = temp[0];
                int value = temp[1];
                for (int next : graph[index]) {
                    int newVal = value | (1 << next);
                    if (newVal == target)
                        return covered;
                    if (!dp[next][newVal]) {
                        queue.add(new int[]{next, newVal});
                        dp[next][newVal] = true;
                    }
                }
            }
        }
        return -1;
    }
}