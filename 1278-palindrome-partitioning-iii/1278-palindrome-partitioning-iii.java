class Solution {
   public int palindromePartition(String s, int k) {
        int len = s.length();
        if (len <= k) return 0;

        int[][] dp = new int[k][len];
        int[][] cache = new int[len][len]; // caching the cost of s.substring(left, right)
        char[] chars = s.toCharArray();  // optimization: avoid calling substrings

        // initialize cache
        for (int i = 0; i < len; ++i) {
            for (int j = i; j < len; ++j) { // optimization: j is always >= i
                cache[i][j] = -1;
            }
        }

        for (int i = 0; i < k; ++i) {
            for (int j = i; j < len; ++j) {
                if (i == 0) {
                    dp[i][j] = cost(chars, i, j, cache); // k = 1
                } else {
                    int min = Integer.MAX_VALUE;
                    for (int p = i; p <= j; ++p) {
                        min = Math.min(min, dp[i - 1][p - 1] + cost(chars, p, j, cache));
                    }
                    dp[i][j] = min;
                }
            }
        }

        return dp[k - 1][len - 1];
    }

    protected int cost(char[] s, int left, int right, int[][] cache) {
        if (cache[left][right] != -1) return cache[left][right];

        int diff = 0, ll = left, rr = right;
        while (ll < rr) {
            if (s[ll++] != s[rr--]) diff++;
        }

        return cache[left][right] = diff;
    }
}