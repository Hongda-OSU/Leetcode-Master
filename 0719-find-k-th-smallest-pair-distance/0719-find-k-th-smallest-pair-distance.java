class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int min = 0, max = nums[nums.length - 1] - nums[0];
        while (min <= max) {
            int pivot = (min + max) >>> 1;
            int left = 0, right = 0, count = 0;
            while (right < nums.length) {
                if (nums[right] - nums[left] > pivot) 
                    left++;
                else {
                    count += right - left;
                    right++;
                }
            }
            if (count >= k) 
                max = pivot - 1;
            else 
                min = pivot + 1;
        }
        return min;
    }
}