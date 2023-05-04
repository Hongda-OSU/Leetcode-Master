class Solution {
    int mod = (int) Math.pow(10, 9) + 7, mask = 0;
    List<List<Integer>> ps;
    Integer[][] dp;
    public int numberWays(List<List<Integer>> hats) {
        ps = new ArrayList<>();
        mask = (1 << hats.size()) - 1;
        for (int i = 0; i < 41; i++) ps.add(new ArrayList<>());
        for (int i = 0; i < hats.size(); i++) {
            for(int h : hats.get(i)) {
                ps.get(h).add(i);
            }
        }
        dp = new Integer[41][1 << hats.size()];
        return dfs(0, 0);
    }
    
    private int dfs(int h, int pa) {  // pa for people assigned mask;
        if (pa == mask) return 1;
        if (h > 40) return 0;
        if (dp[h][pa] != null) return dp[h][pa];
        int res = dfs(h + 1, pa);
        for (int p : ps.get(h)) {
            if ((pa & (1 << p)) > 0) continue; // p is assigned with a hat;
            res = (res + dfs(h + 1, pa | (1 << p))) % mod;
        }
        dp[h][pa] = res;
        return res;
    }
}