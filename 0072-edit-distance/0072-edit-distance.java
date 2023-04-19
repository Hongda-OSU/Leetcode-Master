class Solution {
    private Integer memo[][];
    
    public int minDistance(String word1, String word2) {
        memo = new Integer[word1.length() + 1][word2.length() + 1];
        return minDistanceHelper(word1, word2, word1.length(), word2.length());
    }
    
    private int minDistanceHelper(String w1, String w2, int l1, int l2) {
        if (l1 == 0)
            return l2;
        if (l2 == 0)
            return l1;
        if (memo[l1][l2] != null) 
            return memo[l1][l2];
        int minDist = 0;
        if (w1.charAt(l1 - 1) == w2.charAt(l2 - 1)) {
            minDist = minDistanceHelper(w1, w2, l1 - 1, l2 - 1);
        } else {
            int insert = minDistanceHelper(w1, w2, l1, l2 - 1);
            int delete = minDistanceHelper(w1, w2, l1 - 1, l2);
            int replace = minDistanceHelper(w1, w2, l1 - 1, l2 - 1);
            minDist = Math.min(insert, Math.min(delete, replace)) + 1;
        }
        memo[l1][l2] = minDist;
        return minDist;
    }
}