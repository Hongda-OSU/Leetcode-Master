class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // using dfs
        boolean[] waitList = new boolean[numCourses];
        boolean[] memo = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!canFinishThisCourse(i, prerequisites, waitList, memo))
                return false;
        }
        return true;
    }
    
    public boolean canFinishThisCourse(int course, int[][] prerequisites, boolean[] waitList, boolean[] memo) {
        if (memo[course])
            return true;
        if (waitList[course])
            return false;
        waitList[course] = true;
        for (int[] pre : prerequisites) {
            if (pre[0] == course) {
                if (!canFinishThisCourse(pre[1], prerequisites, waitList, memo))
                    return false;
            }
        }
        waitList[course] = false;
        memo[course] = true;
        return true;
    }
}
