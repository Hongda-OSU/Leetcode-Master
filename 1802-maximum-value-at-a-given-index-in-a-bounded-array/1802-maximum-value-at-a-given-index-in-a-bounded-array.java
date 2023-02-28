class Solution {
    public int maxValue(int n, int index, int maxSum) {
        int low = 1, high = 1_000_000_007, pivot = 0;
        while (low <= high) {
            pivot = (low + high) >>> 1;
            if (sum(pivot, index, n) > maxSum)
                high = pivot - 1;
            else if (sum(pivot + 1, index, n) <= maxSum)
                low = pivot + 1;
            else 
                break;
        }
        return pivot;
    }
    
    public int sum(int max, int idx, int n) {
        long result = sumPart(max - 1, idx) + sumPart(max, n - idx);
        if (result > 1_000_000_007)
            return 1_000_000_007 + 1;
        else 
            return (int)result;
    }
    
    public long sumPart(int i, int num) {
        long result = 0, last = 0, extraOnes = 0;
        if (num >= i) {
            last = 1;
            extraOnes = num - i;
        } else if (num < i) {
            extraOnes = 0;
            last = i - num + 1;
        }
        result = ((last + i) * (i - last + 1)) / 2;
        result += extraOnes;
        return result;
    }
}