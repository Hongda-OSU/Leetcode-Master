class Solution {
    public int singleNonDuplicate(int[] nums) {
        if (nums.length == 1) return nums[0];
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int pivot = (low + high) >>> 1;
            if (nums[pivot] == nums[pivot + 1])
                pivot = pivot - 1;
            if ((pivot - low + 1) % 2 != 0)
                high = pivot;
            else
                low = pivot + 1;
        }
        return nums[low];
    }
}