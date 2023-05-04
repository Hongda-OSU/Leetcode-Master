class Solution {
    
    private static int MOD = 1000000007;

    public int numberWays(List<List<Integer>> hats) {
        int n = hats.size();
        List<Integer>[] h = new List[40];
        for (int i = 0; i < 40; i++) h[i] = new ArrayList<>();
        for (int i = 0; i < hats.size(); i++) {
            for (int hat : hats.get(i)) {
                h[hat - 1].add(i); // convert to 0-indexed
            }
        }

        int[][] dp = new int[41][1 << n];
        dp[0][0] = 1;

        for (int i = 0; i < 40; i++) {
            for (int j = 0; j < 1 << n; j++) {
                dp[i+1][j] = dp[i][j];
                for (int people: h[i]) {
                    int index = 1 << people; 
                    if ((j & index) > 0) {
                        dp[i+1][j] = (dp[i+1][j] + dp[i][j^index]) % MOD;
                    }
                }
            }
        }
        
        return dp[40][(1 << n) - 1];        
    }
}