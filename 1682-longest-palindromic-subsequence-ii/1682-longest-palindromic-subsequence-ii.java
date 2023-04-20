class Solution {
   public int longestPalindromeSubseq(String s) {
        int[][] length = new int[s.length()][27];

        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = 0; j < s.length(); j++) {
                for (int prev = 26; prev >= 0; prev--) {
                    if (i >= j) continue;
                    if (s.charAt(i) - 'a' == prev) {
                        continue;
                    }
                    if (s.charAt(j) - 'a' == prev) {
                        length[j][prev] = length[j - 1][prev];
                        continue;
                    }

                    if (s.charAt(i) == s.charAt(j)) {
                        length[j][prev] = length[j - 1][s.charAt(i) - 'a'] + 2;
                    } else {
                        length[j][prev] =  Math.max(
                            length[j][prev],
                            length[j - 1][prev]
                        );
                    }
                }
            }
        }

        return length[s.length() - 1][26];
    }
}