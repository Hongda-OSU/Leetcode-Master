class Solution {
    public int triangleNumber(int[] nums) {
        int result = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int k = i + 2;
            for (int j = i + 1; j < nums.length - 1 && nums[i] != 0; j++) {
                k = bst(nums, k, nums.length - 1, nums[i] + nums[j]);
                result += k - j - 1;
            }
        }
        return result;
    }
    
    public int bst(int[] nums, int left, int right, int x) {
        while (right >= left && right < nums.length) {
            int pivot = (left + right) >>> 1;
            if (nums[pivot] >= x) 
                right = pivot - 1;
            else 
                left = pivot + 1;
        }
        return left;
    }
}