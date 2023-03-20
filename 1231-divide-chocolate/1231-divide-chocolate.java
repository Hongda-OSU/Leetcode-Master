class Solution {
    public int maximizeSweetness(int[] sweetness, int k) {
        int low = 0, high = 0;
        for (int sweet : sweetness) 
            high += sweet;
        while (low <= high) {
            int level = (low + high) >>> 1;
            if (canCutIntoK(sweetness, level, k + 1))
                low = level + 1;
            else 
                high = level - 1;
        }
        return low - 1;
    }
    
    public boolean canCutIntoK(int[] sweetness, int level, int k) {
        int count = 0, curr = 0;
        for (int i = 0; i < sweetness.length; i++) {
            curr += sweetness[i];
            if (curr >= level) {
                curr = 0;
                count++;
            }
        }
        return count >= k;
    }
}