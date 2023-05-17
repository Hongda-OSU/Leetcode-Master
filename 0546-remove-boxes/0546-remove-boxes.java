class Solution {
  public int removeBoxes(int[] boxes) {
        int n = boxes.length;
        int[][][] dp = new int[n][n][n];
        for(int i=0;i<n;i++)
            for(int streak = 0; streak<n; streak++)
                dp[i][i][streak] = (streak+1)*(streak+1);
        for(int len=1; len<n;len++)
            for(int l=0;l+len<n;l++) {
                int r = l+len;
                for(int streak=0;streak<=l;streak++) {
                    int max = (streak+1)*(streak+1) +dp[l+1][r][0];
                    for(int i=l+1;i<=r;i++)
                        if(boxes[i] == boxes[l])
                            max = Math.max(max, dp[l+1][i-1][0]+dp[i][r][streak+1]);
                    dp[l][r][streak]=max;
                }
            }               
        return dp[0][n-1][0];      
    }
}