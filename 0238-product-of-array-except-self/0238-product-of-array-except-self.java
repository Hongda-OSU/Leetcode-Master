class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0, temp = 1; i < nums.length; i++) {
            // get the prev num in slot
            result[i] = temp;
            temp *= nums[i];
        }
        for (int j = nums.length - 1, temp = 1; j >= 0; j--) {
            result[j] *= temp;
            temp *= nums[j];
        }
        return result;
    }
}