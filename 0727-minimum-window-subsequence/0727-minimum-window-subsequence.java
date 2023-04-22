class Solution {
    public String minWindow(String s1, String s2) {
        char[] arr1 = s1.toCharArray(), arr2 = s2.toCharArray();
        String result = "";
        int i = 0, idx2 = 0, len1 = s1.length(), len2 = s2.length(), len = Integer.MAX_VALUE;
        while (i < len1) {
            if (arr1[i] == arr2[idx2]) {
                idx2++;
                if (idx2 == len2) {
                    int end = i + 1;
                    idx2--;
                    while (idx2 >= 0) {
                        if (arr1[i] == arr2[idx2])
                            idx2--;
                        i--;
                    }
                    i++;
                    idx2++;
                    if (end - i < len) {
                        len = end - i;
                        result = s1.substring(i, end);
                    }
                }
            }
            i++;
        }
        return len == Integer.MAX_VALUE ? "" : result;
    }
}