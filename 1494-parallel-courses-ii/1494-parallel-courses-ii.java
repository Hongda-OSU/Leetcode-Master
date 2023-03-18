class Solution {
      public int minNumberOfSemesters(int n, int[][] relations, int k) {
        int[] prereq = new int[n];
        for (int[] req : relations) {
            prereq[req[1] - 1] |= 1 << (req[0] - 1);
        }
        int[] dp = new int[(1 << n)];
        Arrays.fill(dp, -1);
        return solve(0, n, k, prereq, dp);
    }

    private int solve(int mask, int n, int k, int[] prereq, int[] dp) {
        if (mask == (1 << n) - 1) {
            return 0;
        }
        if (dp[mask] != -1) {
            return dp[mask];
        }
        int availableCourses = 0;
        for (int i = 0; i < n; i += 1) {
            if ((mask & prereq[i]) == prereq[i]) {
                if( (mask & (1<<i))>0 )
                    continue;
                availableCourses |= 1 << i;
            }
        }
        int best = Integer.MAX_VALUE / 2;
        for (int submask = availableCourses; submask > 0; submask = (submask - 1) & availableCourses) {
            if (Integer.bitCount(submask) <= k) {
                best = Math.min(best, 1 + solve(mask | submask, n, k, prereq, dp));
            }
        }
        return dp[mask] = best;
    }
}