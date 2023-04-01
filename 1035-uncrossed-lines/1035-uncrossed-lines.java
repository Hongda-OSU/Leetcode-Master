class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        if (m < n)
            return maxUncrossedLines(nums2, nums1);
        int[] dp = new int[n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0, prev = 0, curr; j < n; j++) {
                curr = dp[j + 1];
                if (nums1[i] == nums2[j])
                    dp[j + 1] = 1 + prev;
                else 
                    dp[j + 1] = Math.max(dp[j + 1], dp[j]);
                prev = curr;
            }
        }
        return dp[n];
    }
}