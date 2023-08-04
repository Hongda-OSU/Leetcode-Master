class Solution {
    public int calculateTime(String keyboard, String word) {
        int[] mapping = new int[26];
        for (int i = 0; i < keyboard.length(); i++) 
            mapping[keyboard.charAt(i) - 'a'] = i;
        int prev = 0, result = 0;
        for (char ch : word.toCharArray()) {
            result += Math.abs(prev - mapping[ch - 'a']);
            prev = mapping[ch - 'a'];
        }
        return result;
    } 
}