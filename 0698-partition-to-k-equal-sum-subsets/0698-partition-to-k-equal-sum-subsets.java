class Solution {
    public boolean canPartitionKSubsets(int[] arr, int k) {
        int totalArraySum = 0;
        int n = arr.length;
        
        for (int i = 0; i < n; ++i) {
            totalArraySum += arr[i];
        }
      
        // If total sum not divisible by k, we can't make subsets.
        if (totalArraySum % k != 0) { 
            return false;
        }
      
        int targetSum = totalArraySum / k;
        
        int[] subsetSum = new int[(1 << n)];
        for (int i = 0; i < (1 << n); ++i) {
            subsetSum[i] = -1;
        }
        // Initially only one state is valid, i.e don't pick anything.
        subsetSum[0] = 0;
        
        for (int mask = 0; mask < (1 << n); mask++) {
            // If the current state has not been reached earlier.
            if (subsetSum[mask] == -1) {
                continue;
            }  
            
            for (int i = 0; i < n; i++) {
                // If the number arr[i] was not picked earlier, and arr[i] + subsetSum[mask]
                // is not greater than the targetSum then add arr[i] to the subset
                // sum at subsetSum[mask] and store the result at subsetSum[mask | (1 << i)].
                if ((mask & (1 << i)) == 0 && subsetSum[mask] + arr[i] <= targetSum) { 
                    subsetSum[mask | (1 << i)] = (subsetSum[mask] + arr[i]) % targetSum;
                }
            }
            
            if (subsetSum[(1 << n) - 1] == 0) {
                return true;
            }
        }
        
        return subsetSum[(1 << n) - 1] == 0;
    }
}