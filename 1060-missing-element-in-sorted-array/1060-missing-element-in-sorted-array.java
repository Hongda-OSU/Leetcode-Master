class Solution {
    public int missingElement(int[] nums, int k) {
        int n = nums.length;
        int left = 0, right = n - 1;
        int missingNum = nums[right] - nums[left] - (right - left);
        if (missingNum < k)
            return nums[right] + k - missingNum;
        while (right - left > 1) {
            int pivot = (left + right) >>> 1;
            missingNum = nums[pivot] - nums[left] - (pivot - left);
            if (k > missingNum) {
                k -= missingNum;
                left = pivot;
            } else {
                right = pivot;
            }
        }
        return nums[left] + k;
    }
}