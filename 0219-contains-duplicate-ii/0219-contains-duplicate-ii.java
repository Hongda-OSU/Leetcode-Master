class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer prev = map.put(nums[i], i);
            if (prev != null && i - prev <= k)
                return true;
        }
        return false;
    }
}