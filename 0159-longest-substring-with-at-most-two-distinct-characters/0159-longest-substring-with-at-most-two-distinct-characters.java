class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int n = s.length();
        if (n < 3)
            return n;
        int left = 0, right = 0, max= 2;
        HashMap<Character, Integer> map = new HashMap<>();
        while (right < n) {
            map.put(s.charAt(right), right++);
            if (map.size() == 3) {
                int idx = Collections.min(map.values());
                map.remove(s.charAt(idx));
                left = idx + 1;
            }
            max = Math.max(max, right - left);
        }
        return max;
    }
}