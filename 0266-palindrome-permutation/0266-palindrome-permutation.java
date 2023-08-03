class Solution {
    public boolean canPermutePalindrome(String s) {
        char[] arr = new char[256];
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (arr[s.charAt(i)] > 0)
                arr[s.charAt(i)]--;
            else
                arr[s.charAt(i)]++;
        }
        for (int i = 0; i < 256; i++) {
            if (arr[i] != 0)
                count++;
        }
        return count <= 1;
    }
}