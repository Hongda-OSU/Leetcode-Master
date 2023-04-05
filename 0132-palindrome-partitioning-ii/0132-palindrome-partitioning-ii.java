class Solution {
    public int minCut(String s) {
        int n = s.length(), min;
        int[] cut = new int[n];
        boolean[][] palindrome = new boolean[n][n];
        for (int j = 0; j < n; j++) {
            min = j;
            for (int i = 0; i <= j; i++) {
                if (s.charAt(i) == s.charAt(j) && (i + 1 > j - 1 || palindrome[i + 1][j - 1])) {
                    palindrome[i][j] = true;
                    min = i == 0 ? 0 : Math.min(min, cut[i - 1] + 1);
                }
            }
            cut[j] = min;
        }
        return cut[n - 1];
    }
}