class Solution {
    public int numKLenSubstrNoRepeats(String S, int K) {
        int ans = 0;
        Set<Character> set = new HashSet<>();
        int i = 0;
        
        for (int j = 0; j < S.length(); j++) {
            while (set.contains(S.charAt(j))) {
                set.remove(S.charAt(i++));
            }
            set.add(S.charAt(j));
            
            if (j - i + 1 == K) {
                ans++;
                set.remove(S.charAt(i++));
            }
        }
        return ans;
    }
}