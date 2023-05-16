class Solution {
    public int helper(int[][] change,String s,int end,int k,Integer[][] dp){
        if(k == end) return 0;
        if(k == 1) return change[0][end-1];
        if(dp[end][k] != null) return dp[end][k];
        int ans = Integer.MAX_VALUE;
        for(int i = k-1;i < end;i++){
            ans = Math.min(ans,helper(change,s,i,k-1,dp)+change[i][end-1]);
        }
        return dp[end][k] = ans;
    }
    public int palindromePartition(String s, int k) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for(int g = 0;g<n;g++){
            for(int i = 0,j = g;j < n;i++,j++){
                if(g == 0) dp[i][j] = 0;
                else if(g == 1){
                    if(s.charAt(i) == s.charAt(j)) dp[i][j] = 0;
                    else dp[i][j] = 1;
                }else{
                    if(s.charAt(i) == s.charAt(j)) dp[i][j] = dp[i+1][j-1];
                    else dp[i][j] = 1+dp[i+1][j-1];
                }
            }
        }
        return helper(dp,s,n,k,new Integer[n+1][k+1]);
    }
}