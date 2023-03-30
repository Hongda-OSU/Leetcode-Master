class Solution {
    public int maxSumAfterOperation(int[] nums) {
        int sum = 0, curr = 0, result = Integer.MIN_VALUE;
        for (int num : nums) {
            curr = Math.max(num * num, Math.max(curr + num, sum + num * num));
            sum = Math.max(num, sum + num);
            result = Math.max(result, curr);
        }
        return result;
    }
}