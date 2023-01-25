class Solution {
    public String minWindow(String s, String t) {
        int[] count = new int[128];
        for (char ch : t.toCharArray()) count[ch]++;
        char[] sourceStr = s.toCharArray();
        String windowStr = "";
        int left = 0, right = 0, charsFoundInWindow = 0, 
            totalCharsToFind = t.length(), minWindowLen = Integer.MAX_VALUE;
        while (right < sourceStr.length) {
            int currentChar = sourceStr[right];
            // Reduce the count of current character
            count[currentChar]--;
            // If current character's count is greater than or equal to 0 if it was also present in target string t
            // and we can say that we have found that character in current window so we increment charsFoundInWindow
            if (count[currentChar] >= 0) charsFoundInWindow++;
            // If we found a window containing all characters of t, find if it's smaller than the smallest window
            // If yes, store the window in windowString to return finally.
            while (charsFoundInWindow == totalCharsToFind) {
                int currentWindowLen = right - left + 1;
                if (minWindowLen > currentWindowLen) {
                    minWindowLen = currentWindowLen;
                    windowStr = s.substring(left, right + 1);
                }
                // Now we need to reduce the window size from left to further look for smaller windows.
                // The current leftmost character was already visited by right pointer windowRight earlier
                // and we had reduced its count in count[]. So now we increment it because
                // we need the count of that character in the remaining window.
                count[sourceStr[left]]++;
                // Now if the last character is greater than 0, it means that character was present in t but
                // is not present in current window so we have to decrement charsFoundInWindow
                if (count[sourceStr[left]] > 0) charsFoundInWindow--;
                left++;
            }
            right++;
        }
        return windowStr;
    }
}