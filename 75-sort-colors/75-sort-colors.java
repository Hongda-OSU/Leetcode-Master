class Solution {
    public void sortColors(int[] nums) {
        int left = 0, right = nums.length - 1, cur = 0;
        while (cur <= right) {
            if (nums[cur] == 0) {
                int temp = nums[left];
                nums[left] = nums[cur];
                nums[cur] = temp;
                left++;
                cur++;
            } else if (nums[cur] == 2) {
                int temp = nums[cur];
                nums[cur] = nums[right];
                nums[right] = temp;
                right--;
            } else {
                cur++;
            }
        }
    }
}