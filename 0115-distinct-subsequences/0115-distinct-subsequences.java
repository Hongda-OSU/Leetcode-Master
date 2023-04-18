class Solution {
    
    // Dictionary that we will use for memoization
    private HashMap<Pair<Integer, Integer>, Integer> memo;
    
    private int recurse(String s, String t, int i, int j) {
        
        int M = s.length();
        int N = t.length();
        
        // Base case
        if (i == M || j == N || M - i < N - j) {
            return j == t.length() ? 1 : 0;
        }
        
        Pair<Integer, Integer> key = new Pair<Integer, Integer>(i, j);
        
        // Check to see if the result for this recursive
        // call is already cached
        if (this.memo.containsKey(key)) {
            return this.memo.get(key);
        }
        
        // Always calculate this result since it's
        // required for both the cases
        int ans = this.recurse(s, t, i + 1, j);
        
        // If the characters match, then we make another
        // recursion call and add the result to "ans"
        if (s.charAt(i) == t.charAt(j)) {
            ans += this.recurse(s, t, i + 1, j + 1);
        }
        
        // Cache the result
        this.memo.put(key, ans);
        return ans;
    }
    
    public int numDistinct(String s, String t) {
        
        this.memo = new HashMap<Pair<Integer, Integer>, Integer>();        
        return this.recurse(s, t, 0, 0);
    }
}