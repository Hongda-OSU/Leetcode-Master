class Solution {
    public int superEggDrop(int k, int n) {
        int[][] memo = new int[k + 1][n + 1];
        return helper(k, n, memo);
    } 
    
    public int helper(int k, int n, int[][] memo) {
        if (n <= 1)
            return n;
        if (k == 1)
            return n;
        if (memo[k][n] > 0)
            return memo[k][n];
        int low = 1, high = n, result = n;
        while (low < high) {
            int pivot = low + (high - low) / 2;
            int left = helper(k - 1, pivot - 1, memo);
            int right = helper(k, n - pivot, memo);
            result = Math.min(result, Math.max(left, right) + 1);
            if (left == right)
                break;
            else if (left < right)
                low = pivot + 1;
            else 
                high = pivot;
        }
        memo[k][n] = result;
        return result;
    } 
}