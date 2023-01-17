class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0, temp = 1; i < nums.length; i++) {
            // get the prev nums multiplication in slot
            // ex: [1, 2, 3, 4] -> result: [1, 1, 2, 6]
            result[i] = temp;
            temp *= nums[i];
        }
        for (int j = nums.length - 1, temp = 1; j >= 0; j--) {
            // get the next nums multiplication in slot
            // result: [1, 1, 2, 6] -> [ ..., 4 * 3 * 2 = 12, 6 * 1 = 6]
            result[j] *= temp;
            temp *= nums[j];
        }
        return result;
    }
}