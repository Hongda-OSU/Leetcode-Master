class Solution {
    public int strStr(String haystack, String needle) {
        int m = haystack.length(), n = needle.length();
        for (int i = 0; i <= m - n; i++) {
            for (int j = 0; j < n; j++) {
                if (needle.charAt(j) != haystack.charAt(i + j))
                    break;
                if (j == n - 1)
                    return i;
            }
        }
        return -1;
    }
}