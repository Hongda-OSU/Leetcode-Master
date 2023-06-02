class Solution {
    char[] ring, key;
    Integer[][] dp;
    public int findRotateSteps(String ring, String key) {
        this.ring = ring.toCharArray();
        this.key = key.toCharArray();
        dp = new Integer[ring.length()][key.length()];
        return dfs(0, 0);
    }
    
    int dfs(int ringIndex, int keyIndex) {
        if (keyIndex >= key.length)
            return 0;
        if (dp[ringIndex][keyIndex] != null)
            return dp[ringIndex][keyIndex];
        if (ring[ringIndex] == key[keyIndex])
            return dp[ringIndex][keyIndex] = 
                1 + dfs(ringIndex, keyIndex + 1);
        
        char target = key[keyIndex];
        int i = ringIndex, steps = 1;
        while (ring[i] != target) {
            i = i == ring.length - 1 ? 0 : i + 1;
            ++steps;
        }
        int clockwise = steps + dfs(i, keyIndex + 1);
        
        i = ringIndex;
        steps = 1;
        while (ring[i] != target) {
            i = i == 0 ? ring.length - 1 : i - 1;
            ++steps;
        }
        int counterClockwise = steps + dfs(i, keyIndex + 1);
        
        return dp[ringIndex][keyIndex] =
            Math.min(clockwise, counterClockwise);
    }
}