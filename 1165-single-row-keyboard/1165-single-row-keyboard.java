class Solution {
public int calculateTime(String keyboard, String word) {
        //fill mapping for the keyboard chars and indexes
        int[] map = new int[26];
        int j = 0;
        for (char ch : keyboard.toCharArray()) {
            map[ch - 'a'] = j++;
        }
        
        int res = 0;
        //reuse j as a placeholder for the previously typed char. Starting from 0
        j = 0;
        for (char ch : word.toCharArray()) {
            //find position of the current char as per keyboard mapping
            int idx = map[ch - 'a'];
            //add difference to the result
            res += Math.abs(j - idx);
            //save current as previous position for the next iteration
            j = idx;
        }
        return res;
    }
}