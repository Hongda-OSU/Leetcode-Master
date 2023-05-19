class Solution {
   int dfs(int[] dp, int[] a, int[] b, int i, int mask) {
    if (i >= a.length)
        return 0;
    if (dp[mask] == Integer.MAX_VALUE)
        for (int j = 0; j < b.length; ++j)
            if ((mask & (1 << j)) == 0)
                dp[mask] = Math.min(dp[mask], (a[i] ^ b[j]) + dfs(dp, a, b, i + 1, mask + (1 << j)));
    return dp[mask];
}
public int minimumXORSum(int[] nums1, int[] nums2) {
    int dp[] = new int[1 << nums2.length];
    Arrays.fill(dp, Integer.MAX_VALUE);
    return dfs(dp, nums1, nums2, 0, 0);
}
}