class Solution {
     static final long MOD=1_000_000_007;
    public int waysToDistribute(int n, int k) {
        long mod=1_000_000_007;
        long[] memo=new long[n];
        Arrays.fill(memo,1);
        for(int bags=2;bags<=k;bags++) {
            long diag=memo[bags-1], last=1;
            for(int candies=bags;candies<n;candies++) {
                long tmp=memo[candies];
                last=memo[candies]=(diag+bags*last)%mod;
                diag=tmp;
            }
        }
        return (int)memo[n-1];
    }
}