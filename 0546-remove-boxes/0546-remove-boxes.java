class Solution {
  int[][][] memo; 
    public int removeBoxes(int[] boxes) {
        int size = boxes.length;
        memo = new int[size][size][size];
        return dfs(boxes, 0, size - 1, 0); 
    }
    
    int dfs(int[] boxes, int l, int r, int k) {
        if (l > r) return 0; 
        if (memo[l][r][k] != 0) return memo[l][r][k]; 
        memo[l][r][k] = dfs(boxes, l + 1 , r, 0) + (k + 1) * (k + 1); 
        for (int i = l + 1; i <= r; i++) {
            if (boxes[l] == boxes[i]) {
                memo[l][r][k] = Math.max(memo[l][r][k], dfs(boxes, l + 1, i - 1, 0) + dfs(boxes, i, r, k + 1)); 
            }
        }
        return memo[l][r][k]; 
    }
}