class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0, right = 0, maxLength = 0;
        while (right < s.length()) {
            char ch = s.charAt(right);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            // if duplicate found, left move to the first occurence of the duplicate, new substring begins there
            while (map.get(ch) > 1) {
                char ch2 = s.charAt(left);
                map.put(ch2, map.get(ch2) - 1);
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        } 
        return maxLength;
    }
}