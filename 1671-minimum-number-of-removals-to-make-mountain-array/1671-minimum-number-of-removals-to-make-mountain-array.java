class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        int[] LIS = new int[n], LDS = new int[n];
        Arrays.fill(LIS, 1);
        Arrays.fill(LDS, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && LIS[j] + 1 > LIS[i])
                    LIS[i] = LIS[j] + 1;
            } 
        }
        int max = 0;
        for (int i = n - 2; i >= 0; i--) {
            for (int j = n - 1; j > i; j--) {
                if (nums[i] > nums[j] && LDS[j] + 1 > LDS[i])
                    LDS[i] = LDS[j] + 1;
            }
            if (LIS[i] > 1 && LDS[i] > 1)
                max = Math.max(LIS[i] + LDS[i] - 1, max);
        }
        return n - max;
    }
}