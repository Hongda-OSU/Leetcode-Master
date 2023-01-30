class Solution {
    public int minDistance(String word1, String word2) {
        int w1 = word1.length(), w2 = word2.length();
        int[][] memo = new int[w1 + 1][w2 + 1];
        return minDistanceHelper(word1, word2, w1, w2, memo);
    }
    
    public int minDistanceHelper(String word1, String word2, int w1, int w2, int[][] memo) {
        if (memo[w1][w2] != 0)
            return memo[w1][w2];
        if (w1 == 0)
            return w2;
        if (w2 == 0)
            return w1;
        if (word1.charAt(w1 - 1) == word2.charAt(w2 - 1)) {
            return minDistanceHelper(word1, word2, w1 - 1, w2 - 1, memo);
        } else {
            int delete = 1 + minDistanceHelper(word1, word2, w1 - 1, w2, memo); // delete operation
            int replace = 1 + minDistanceHelper(word1, word2, w1 - 1, w2 - 1, memo); // replace operation
            int insert = 1 + minDistanceHelper(word1, word2, w1, w2 - 1, memo); // insert operation
            return memo[w1][w2] = Math.min(delete, Math.min(replace, insert));
        }
    }
}