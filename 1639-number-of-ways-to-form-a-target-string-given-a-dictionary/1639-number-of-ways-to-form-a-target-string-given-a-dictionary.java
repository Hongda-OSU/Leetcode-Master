class Solution {
    public int numWays(String[] words, String target) {
        int n = target.length();
        long mod = (long)1e9 + 7;
        long[] result = new long[n + 1];
        result[0] = 1;
        for (int i = 0; i < words[0].length(); i++) {
            int[] count = new int[26];
            for (String word : words)
                count[word.charAt(i) - 'a']++;
            for (int j = n - 1; j >= 0; j--) 
                result[j + 1] += result[j] * count[target.charAt(j) - 'a'] % mod;
        }
        return (int)(result[n] % mod);
    }
}