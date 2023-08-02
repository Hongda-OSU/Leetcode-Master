class Solution {
    public void reverseWords(char[] s) {
        reverse(s, 0, s.length-1);
        int f; 
        int start = 0;

        while( (f = findSpace(start, s))!=-1) {
            reverse(s, start, f-1);
            start = f + 1;
        }
        reverse(s, start, s.length-1);
    }

    int findSpace(int start, char[]s) {
        int n = s.length;
        int i = start;

        while(i<n && s[i] !=' ') {
            i++;
        }
        if (i == n)
          return -1;
        return i;
    }

    void reverse(char []s, int start, int end) {
        while(start < end) {
            char t = s[start];
            s[start] = s[end];
            s[end] = t;
            start++;
            end--;
        }
    }
}