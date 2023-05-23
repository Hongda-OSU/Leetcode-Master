class Solution {
    public int numberWays(List<List<Integer>> hats) {
        int n = hats.size(), sCnt = 2<<(n-1);
        int[] dp = new int[sCnt];
        dp[0] = 1;
        List<Integer>[] h2p= new List[40];
        Arrays.setAll(h2p, d -> new ArrayList<>());
        for(int i = 0; i < n; ++i){
            for(int h: hats.get(i)){
                h2p[h-1].add(i);
            }
        }

        for(int i = 0; i < 40; ++i){
            int[] newDp = Arrays.copyOf(dp, sCnt);
            for(int p: h2p[i]){
                for(int j =0; j < sCnt; ++j){
                    if(((1<<p) & j) == 0){
                        newDp[j + (1<<p)] = (newDp[j + (1<<p)]+dp[j]) % 1000000007;
                    }
                }   
            }
            dp = newDp;
        }
        return dp[sCnt-1];
    }
}