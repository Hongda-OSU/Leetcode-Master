class Solution {
    private String[][] dp;
    
    public String encode(String s) {
        int n = s.length();
        dp = new String[n][n];
        return dfs(s, 0, n - 1);
    }
    
    private String dfs(String str, int left, int right) {
        int n = str.length();
        if (left > right)
            return "";
        if (dp[left][right] != null)
            return dp[left][right];
        String result = str.charAt(left) + dfs(str, left + 1, right);
        int[] lps = new int[right - left + 1];
        int lp = 0;
        for (int j = 1; j < right - left + 1; j++) {
            while (lp > 0 && str.charAt(left + j) != str.charAt(left + lp))
                lp = lps[lp - 1];
            if (str.charAt(left + j) == str.charAt(left + lp)) {
                lps[j] = ++lp;
                int len = (j + 1) - lps[j];
                if ((j + 1) % len == 0) {
                    int mul = (j + 1) / len;
                    String next = mul + "[" + dfs(str, left, left + len - 1) + "]" + dfs(str, left + j + 1, right);
                    if (next.length() < result.length())
                        result = next;
                }
            }
        }
        return dp[left][right] = result;
    }
}