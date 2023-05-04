class Solution {
    public int assignBikes(int[][] workers, int[][] bikes) {
        int minDist = Integer.MAX_VALUE;
        int N = workers.length;
        int M = bikes.length;
        int[] dp = new int[1 << M];
        
        for (int s = 1; s < (1 << M); ++s) {
            int w = Integer.bitCount(s);
            if (w > N) continue;
            
            dp[s] = Integer.MAX_VALUE;
            for (int i = 0; i < M; ++i) {
                if ((s & (1 << i)) == 0) continue;
                
                int preS = s ^ (1 << i);
                dp[s] = Math.min(dp[s], dp[preS] + getDistance(workers[w-1], bikes[i]));
            }
            
            if (w == N)
                minDist = Math.min(minDist, dp[s]);
        }
        
        return minDist;
    }
    
    private int getDistance(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }
}