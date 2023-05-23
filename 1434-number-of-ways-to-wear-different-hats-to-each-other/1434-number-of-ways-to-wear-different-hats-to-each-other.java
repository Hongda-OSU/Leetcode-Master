class Solution {
    public int numberWays(List<List<Integer>> hats) {
        int mod = 1_000_000_007;
        int n = hats.size(), count = 2 << (n - 1);
        int[] dp = new int[count];
        dp[0] = 1;
        List<Integer>[] h2p = new List[40];
        Arrays.setAll(h2p, d -> new ArrayList<>());
        for (int i = 0; i < n; i++) {
            for (int h : hats.get(i)) 
                h2p[h - 1].add(i);
        }
        for (int i = 0; i < 40; i++) {
            int[] temp = Arrays.copyOf(dp, count);
            for (int p : h2p[i]) {
                for (int j = 0; j < count; j++) {
                    if (((1 << p) & j) == 0) 
                        temp[j + (1 << p)] = (temp[j + (1 << p)] + dp[j]) % mod;
                }
            }
            dp = temp;
        }
        return dp[count - 1];
    }
}