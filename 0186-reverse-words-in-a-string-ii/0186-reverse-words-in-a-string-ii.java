class Solution {
    public void reverseWords(char[] s) {
        reverse(s, 0, s.length - 1);
        reverseEachWord(s);
    }
    
    private void reverse(char[] arr, int left, int right) {
        while (left < right) {
            char temp = arr[left];
            arr[left++] = arr[right];
            arr[right--] = temp;
        }
    }
    
    private void reverseEachWord(char[] arr) {
        int n = arr.length;
        int start = 0, end = 0;
        while (start < n) {
            while (end < n && arr[end] != ' ')
                end++;
            reverse(arr, start, end - 1);
            start = end + 1;
            end++;
        }
    }
}