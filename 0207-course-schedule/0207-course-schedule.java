class Solution {
    public  boolean[] memo;
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // using dfs
        memo = new boolean[numCourses];
        boolean[] waitList = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!canFinishThisCourse(i, prerequisites, waitList))
                return false;
        }
        return true;
    }
    
    public boolean canFinishThisCourse(int course, int[][] prerequisites, boolean[] waitList) {
        if (memo[course])
            return true;
        if (waitList[course])
            return false;
        waitList[course] = true;
        for (int[] pre : prerequisites) {
            if (pre[0] == course) {
                if (!canFinishThisCourse(pre[1], prerequisites, waitList))
                    return false;
            }
        }
        waitList[course] = false;
        memo[course] = true;
        return true;
    }
}
