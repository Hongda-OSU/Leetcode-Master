class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        int prefixSum = 0, longestSubArray = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            if (prefixSum == k)
                longestSubArray = i + 1;
            if (map.containsKey(prefixSum - k))
                longestSubArray = Math.max(longestSubArray, i - map.get(prefixSum - k));
            if (!map.containsKey(prefixSum))
                map.put(prefixSum, i);
        }
        return longestSubArray;
    }
}