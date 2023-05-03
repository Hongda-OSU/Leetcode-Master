class Solution {
    private boolean backtrack(int[] arr, int index, int count, int currSum, int k, 
                              int targetSum, Integer mask, HashMap<Integer, Boolean> memo) {
                                  
        int n = arr.length;
      
        // We made k - 1 subsets with target sum and last subset will also have target sum.
        if (count == k - 1) { 
            return true;
        }
        
        // No need to proceed further.
        if (currSum > targetSum) { 
            return false;
        }
        
        // If we have already computed the current combination.
        if (memo.containsKey(mask)) {
            return memo.get(mask);
        }
      
        // When curr sum reaches target then one subset is made.
        // Increment count and reset current sum.
        if (currSum == targetSum) {
            boolean ans = backtrack(arr, 0, count + 1, 0, k, targetSum, mask, memo);
            memo.put(mask, ans);
            return ans;
        }
        
        // Try not picked elements to make some combinations.
        for (int j = index; j < n; ++j) {
            if (((mask >> j) & 1) == 0) {
                // Include this element in current subset.
                mask = (mask | (1 << j));
                
                // If using current jth element in this subset leads to make all valid subsets.
                if (backtrack(arr, j + 1, count, currSum + arr[j], k, targetSum, mask, memo)) {
                    return true;
                }
                
                // Backtrack step.
                mask = (mask ^ (1 << j));
            }
        } 
      
        // We were not able to make a valid combination after picking each element from the array,
        // hence we can't make k subsets.
        memo.put(mask, false);
        return false;
    }
    
    void reverse(int[] arr) {
        for (int i = 0, j = arr.length - 1; i < j; i++, j--) { 
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
  
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
      
        // Sort in decreasing order.
        Arrays.sort(arr);
        reverse(arr);
        
        int targetSum = totalArraySum / k;
        Integer mask = 0;
        
        // Memoize the ans using taken element's string as key.
        HashMap<Integer, Boolean> memo = new HashMap<>();
      
        return backtrack(arr, 0, 0, 0, k, targetSum, mask, memo);
    }
}