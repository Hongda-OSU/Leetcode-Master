class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int m = str1.length(), n = str2.length();
        int[][] memo = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char ch1 = str1.charAt(i - 1), ch2 = str2.charAt(j - 1);
                if (ch1 == ch2)
                    memo[i][j] = 1 + memo[i - 1][j - 1];
                else
                    memo[i][j] = Math.max(memo[i - 1][j], memo[i][j - 1]);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (m > 0 && n > 0) {
            if (memo[m][n] == memo[m - 1][n]) {
                sb.append(str1.charAt(m - 1));
                m--;
            } else if (memo[m][n] == memo[m][n - 1]) {
                sb.append(str2.charAt(n - 1));
                n--;
            } else {
                sb.append(str1.charAt(m - 1));
                m--;
                n--;
            }
        }
        while (m-- > 0)
            sb.append(str1.charAt(m));
        while (n-- > 0)
            sb.append(str2.charAt(n));
        return sb.reverse().toString();
    }
}