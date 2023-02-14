class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int min = 0, max = Integer.MAX_VALUE;
        while (min + 1 < max) {
            int pivot = (min + max) >>> 1;
            int operations = 0;
            for (int num : nums)
                operations += (num - 1) / pivot;
            if (operations <= maxOperations) 
                max = pivot;
            else 
                min = pivot;
        }
        return max;
    }
}