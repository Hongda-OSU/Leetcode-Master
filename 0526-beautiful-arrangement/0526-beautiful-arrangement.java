class Solution {
    private int count = 0;
    
    public int countArrangement(int n) {
        if (n == 0)
            return 0;
        int[] nums = new int[n + 1];
        for (int i = 0; i <= n; i++)
            nums[i] = i;
        helper(nums, n);
        return count;
    } 
    
    private void helper(int[] nums, int start) {
        if (start == 0) {
            count++;
            return;
        }
        for (int i = start; i > 0; i--) {
            swap(nums, start, i);
            if (nums[start] % start == 0 || start % nums[start] == 0)
                helper(nums, start - 1);
            swap(nums, i, start);
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
} 