class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int[] count = new int[128];
        for (char ch : p.toCharArray())
            count[ch]++;
        List<Integer> result = new ArrayList<>();
        for (int left = 0, right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            count[ch]--;
            while (count[ch] < 0) {
                count[s.charAt(left)]++;
                left++;
            }
            if (right - left + 1 == p.length())
                result.add(left);
        }
        return result;
    }
}