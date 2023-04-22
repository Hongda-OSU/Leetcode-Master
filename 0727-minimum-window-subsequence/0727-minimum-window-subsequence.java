class Solution {
    public String minWindow(String S, String T) {
        char[] s = S.toCharArray(), t = T.toCharArray();
        String res = "";
        int i = 0, tindex = 0, slen = s.length, tlen = t.length, len = Integer.MAX_VALUE;
        while(i < slen) {
            if(s[i] == t[tindex]) {
                tindex++; 
                if(tindex == tlen) { // all chars in T has been matched
                    int end = i+1; //i is the last match index in S
                    tindex--; // now tindex is the last index in T
                    while(tindex >= 0) {  //both i and tindex move back
                        if(s[i] == t[tindex]){
                            tindex--;
                        }
                        i--;
                    }
                    i++;  //we found the first match index in S
                    tindex++;  //now tindex == 0, the first match index in T
                    if(end - i < len) { //optimization ops
                        len = end - i;
                        res = S.substring(i, end); // [i, end) is the matching subsequence
                    }
                }
            }
            i++;
        }
        return len == Integer.MAX_VALUE ? "" : res;
    }
}