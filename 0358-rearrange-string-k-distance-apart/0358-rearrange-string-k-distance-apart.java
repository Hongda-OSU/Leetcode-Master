class Solution {
    public String rearrangeString(String s, int k) {
        int n = s.length();
        int[] count = new int[26];
        int[] valid = new int[26];
        for (int i = 0; i < n; i++)
            count[s.charAt(i) - 'a']++;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int candidatePos = findValidMax(count, valid, i);
            if (candidatePos == -1)
                return "";
            count[candidatePos]--;
            valid[candidatePos] = i + k;
            sb.append((char)('a' + candidatePos));
        }
        return sb.toString();
    }
    
    public int findValidMax(int[] count, int[] valid, int idx) {
        int max = Integer.MIN_VALUE;
        int candidatePos = -1;
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0 && count[i] > max && idx >= valid[i]) {
                max = count[i];
                candidatePos = i;
            }
        }
        return candidatePos;
    }
}