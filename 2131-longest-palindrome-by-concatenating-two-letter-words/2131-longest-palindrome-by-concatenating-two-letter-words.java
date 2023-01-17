class Solution {
    public int longestPalindrome(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        // symmetric like "aa" is also palindrome
        int pairs = 0, symmetrics = 0;
        for (String word : words) {
            String reverse = new StringBuilder(word).reverse().toString();
            if (map.getOrDefault(reverse, 0) > 0) {
                pairs++;
                // decrease reverse
                map.merge(reverse, -1, (a, b) -> a + b);
                symmetrics -= word.charAt(0) == word.charAt(1) ? 1 : 0;
            } else {
                // increase word
                map.merge(word, 1, (a, b) -> a + b);
                symmetrics += word.charAt(0) == word.charAt(1) ? 1 : 0;
            } 
        }
        return 4 * pairs + (symmetrics > 0 ? 2 : 0);
    }
}