class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // using dfs
        ArrayList[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++)
            graph[i] = new ArrayList<>();
        boolean[] visited = new boolean[numCourses];
        boolean[] dp = new boolean[numCourses];
        for (int i = 0; i < prerequisites.length; i++) 
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(graph, visited, i, dp))
                return false;
        }
        return true;
    }
    
    public boolean dfs(ArrayList[] graph, boolean[] visited, int course, boolean[] dp) {
        if (visited[course])
            return dp[course];
        else 
            visited[course] = true;
        for (int i = 0; i < graph[course].size(); i++) {
            if (!dfs(graph, visited, (int)graph[course].get(i), dp)) {
                dp[course] = false;
                return false;
            }
        }
        dp[course] = true;
        return true;
    }
}