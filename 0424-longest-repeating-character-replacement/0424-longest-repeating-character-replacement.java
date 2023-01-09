class Solution {
    public int characterReplacement(String s, int k) {
        int len = s.length();
        int[] sMapping = new int[26];
        // maxLength: largest count of a sigle unique character in the current window
        int left = 0, maxLength = 0, mostFreqLetter = 0;
        for (int right = 0; right < len; right++) {
            sMapping[s.charAt(right) - 'A']++;
            mostFreqLetter = Math.max(mostFreqLetter, sMapping[s.charAt(right) - 'A']);
            int letterToChange = (right - left + 1) - mostFreqLetter;
            if (letterToChange > k) {
                sMapping[s.charAt(left) - 'A']--;
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}