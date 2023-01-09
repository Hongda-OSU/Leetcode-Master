class Solution {
    public int characterReplacement(String s, int k) {
        int len = s.length();
        int[] alphaMapping = new int[26];
        // maxLength = largest count of a single, unique character in the current window
        int left = 0, maxLength = 0, mostFreqLetter = 0;
        for (int right = 0; right < len; right++) {
            alphaMapping[s.charAt(right) - 'A']++;
            mostFreqLetter = Math.max(mostFreqLetter, alphaMapping[s.charAt(right) - 'A']);
            int lettersToChange = (right - left + 1) - mostFreqLetter;
            if (lettersToChange > k) {
                alphaMapping[s.charAt(left) - 'A']--;
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}