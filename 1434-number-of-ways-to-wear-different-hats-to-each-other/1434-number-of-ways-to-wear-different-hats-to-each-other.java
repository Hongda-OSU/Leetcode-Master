class Solution {
    public int numberWays(List<List<Integer>> hats) {
        int n = hats.size();
        List<Integer>[] h2p = new List[41];
        for (int i = 1; i <= 40; i++)
            h2p[i] = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int hat : hats.get(i))
                h2p[hat].add(i);
        }
        Integer[][] dp = new Integer[41][1024];
        return dfs(h2p, (1 << n) - 1, 1, 0, dp);
    }
    
    private int dfs(List<Integer>[] h2p, int allMask, int hat, int assignedPeople, Integer[][] dp) {
        if (assignedPeople == allMask)
            return 1;
        if (hat > 40)
            return 0;
        if (dp[hat][assignedPeople] != null)
            return dp[hat][assignedPeople];
        int result = dfs(h2p, allMask, hat + 1, assignedPeople, dp);
        for (int p : h2p[hat]) {
            if (((assignedPeople >> p) & 1) == 1) continue;
            result += dfs(h2p, allMask, hat + 1, assignedPeople | (1 << p), dp);
            result %= 1_000_000_007;
        }
        return dp[hat][assignedPeople] = result;
    }
}