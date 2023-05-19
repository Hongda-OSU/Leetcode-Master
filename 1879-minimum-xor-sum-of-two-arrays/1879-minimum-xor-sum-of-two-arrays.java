class Solution {
    public int minimumXORSum(int[] nums1, int[] nums2) {
        int[] dp = new int[1 << nums2.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        return dfs(dp, nums1, nums2, 0, 0);
    }
    
    private int dfs(int[] dp, int[] nums1, int[] nums2, int i, int mask) {
        if (i >= nums1.length)
            return 0;
        if (dp[mask] == Integer.MAX_VALUE) {
            for (int j = 0; j < nums2.length; j++) {
                if ((mask & (1 << j)) == 0)
                    dp[mask] = Math.min(dp[mask], (nums1[i] ^ nums2[j]) + 
                                        dfs(dp, nums1, nums2, i + 1, mask + (1 << j)));
            }
        }
        return dp[mask];
    }
} 