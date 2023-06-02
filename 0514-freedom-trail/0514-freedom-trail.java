class Solution {
    private char[] ring, key;
    private Integer[][] dp;
    
    public int findRotateSteps(String ring, String key) {
        this.ring = ring.toCharArray();
        this.key = key.toCharArray();
        dp = new Integer[ring.length()][key.length()];
        return dfs(0, 0);
    }
    
    private int dfs(int rIndex, int kIndex) {
        if (kIndex >= key.length)
            return 0;
        if (dp[rIndex][kIndex] != null)
            return dp[rIndex][kIndex];
        if (ring[rIndex] == key[kIndex])
            return dp[rIndex][kIndex] = 1 + dfs(rIndex, kIndex + 1);
        char ch = key[kIndex];
        int i = rIndex, steps = 1;
        while (ring[i] != ch) {
            i = i == ring.length - 1 ? 0 : i + 1;
            steps += 1;
        }
        int clockwise = steps + dfs(i, kIndex + 1);
        i = rIndex;
        steps = 1;
        while (ring[i] != ch) {
            i = i == 0 ? ring.length - 1 : i - 1;
            steps += 1;
        }
        int counterClockwise = steps + dfs(i, kIndex + 1);
        return dp[rIndex][kIndex] = Math.min(clockwise, counterClockwise);
    }
}