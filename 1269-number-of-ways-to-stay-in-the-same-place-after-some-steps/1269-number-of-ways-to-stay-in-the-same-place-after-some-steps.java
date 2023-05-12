class Solution {
    int dp[][];
    public int numWays(int steps, int arrLen) {
        dp=new int[501][501];
        for(int row[]:dp) Arrays.fill(row,-1);
        return rec(steps,arrLen,0);
    }
    public int rec(int steps,int len,int index){
        if(index<0 || index>=len || steps<0) return 0;
        if(steps==0 && index==0) return 1;
        if(dp[steps][index]!=-1) return dp[steps][index];

        int ans = ((rec(steps-1,len,index+1) + rec(steps-1,len,index-1))%1000000007 + rec(steps-1,len,index))%1000000007;

        return dp[steps][index]=ans;
    }
}