class Solution {
    public int numKLenSubstrNoRepeats(String s, int k) {
        char[] str = s.toCharArray();
        int n = str.length;
        if (n < k) {
            return 0;
        }
        int repeated = 0;
        int[] cnt = new int[26];
        for (int i = 0; i < k; i++) {
            if (++cnt[str[i] - 'a'] == 2) {
                ++repeated;
            }
        }
        int ans = repeated > 0 ? 0 : 1;
        for (int i = k; i < n; i++) {
            if (cnt[str[i - k] - 'a']-- == 2) {
                --repeated;
            }
            if (++cnt[str[i] - 'a'] == 2) {
                ++repeated;
            }
            if (repeated == 0) {
                ans++;
            }
        }
        return ans;
    }
}