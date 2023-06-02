class Solution {
    String[][] dp;
    public String encode(String s) {
        int n = s.length();
        dp = new String[n][n];
        return dfs(s, 0, n -1);
    }

    String dfs(String s, int l, int r){
        int n = s.length();
        if(l > r)
            return "";
        if(dp[l][r] != null)
            return dp[l][r];
        String res = s.charAt(l) + dfs(s, l + 1, r);
        int[] lps = new int[r - l + 1];
        int lp = 0;
        for(int j = 1; j < r - l + 1; j++){
            while(lp > 0 && s.charAt(l + j) != s.charAt(l + lp)){
                lp = lps[lp - 1];
            }
            if(s.charAt(l + j) == s.charAt(l + lp)){
                lps[j] = ++lp;
                int len = (j + 1) - lps[j];
                if((j + 1) % len == 0){
                    int mul = (j + 1)/len;
                    String next = mul + "[" + dfs(s, l, l + len - 1) + "]" + dfs(s, l + j + 1, r);
                    if(next.length() < res.length())
                        res = next;
                }
            }
        }
        return dp[l][r] = res;
    }
}