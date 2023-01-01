class Solution {
    public String reverseWords(String s) {
        int reverseAt = -1, len = s.length();
        char[] copy = s.toCharArray();
        for (int i = 0; i <= len; i++) {
            if (i == len || s.charAt(i) == ' ') {
                int start = reverseAt + 1;
                int end = i - 1;
                reverse(copy, start, end);
                reverseAt = i;
            }
        }
        return new String(copy);
    }
    
    public void reverse(char[] s, int start, int end) {
        while (start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }
}