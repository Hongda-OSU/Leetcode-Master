class Solution {
    public int superEggDrop(int k, int n) {
        int low = 1, high = n;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (helper(mid, k, n) < n)
                low = mid + 1;
            else 
                high = mid;
        }
        return low;
    }
    
    private int helper(int x, int k, int n) {
        int result = 0, r = 1;
        for (int i = 1; i <= k; i++) {
            r *= x - i + 1;
            r /= i;
            result += r;
            if (result > n)
                break;
        }
        return result;
    }
}