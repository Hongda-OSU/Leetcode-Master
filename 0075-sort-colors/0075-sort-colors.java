class Solution {
    public void sortColors(int[] nums) {
        int left = 0, right = nums.length - 1, curr = 0;
        while (curr <= right) {
            if (nums[curr] == 0) {
                int temp = nums[left];
                nums[left] = nums[curr];
                nums[curr] = temp;
                left++;
                curr++;
            } else if (nums[curr] == 2) {
                int temp = nums[curr];
                nums[curr] = nums[right];
                nums[right] = temp;
                right--;
            } else {
                curr++;
            }
        }
    }
}