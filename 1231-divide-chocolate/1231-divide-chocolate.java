class Solution {
    public int maximizeSweetness(int[] sweetness, int K) {
		// Minimum and maximum level of sweetness to use in binary search.
        int l = 0;
        int hi = 0;
        
        for (int s : sweetness) {
            hi += s;
        }
        
        while (l <= hi) {
		    // hypothesize that we can cut into at least `k + 1`  parts, each has `level` or more sum of sweetness.
            int level = (l + hi) / 2;
            
			// Test if we can cut into `k + 1`  or more parts
            if (canCutIntoK(sweetness, level, K + 1)) {
				// hypothesis was correct, try again with greater level of sweetness
                l = level + 1;
            } else {
				// hypothesis was false, try again with smaller level of sweetness
                hi = level -1;
            }
        }
        
		// `l` increases by 1 after every correct sweet level, so the final correct answer must be `l - 1`
        return l - 1;
    }
    
    boolean canCutIntoK(int[] sweetness, int level, int K) {
        int cnt = 0;
        int curr = 0;
        
        for (int i = 0; i < sweetness.length; i++) {
            curr += sweetness[i];
            
            if (curr >= level) {
                curr = 0;
                cnt++;
            }
        }
        
        return cnt >= K;
    }
}