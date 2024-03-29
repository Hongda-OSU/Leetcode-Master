class Solution {
    public int trap(int[] height) {
        int n = height.length;
        if (n <= 2) return 0;
        int[] leftMax = new int[n], rightMax = new int[n];
        leftMax[0] = height[0];
        rightMax[n - 1] = height[n - 1];
        for (int i = 1, j = n - 2; i < n; i++, j--) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
            rightMax[j] = Math.max(rightMax[j + 1], height[j]);
        }
        int totalWater = 0;
        for (int k = 1; k < n - 1; k++) {
            int water = Math.min(leftMax[k - 1], rightMax[k + 1]) - height[k];
            totalWater += water > 0 ? water : 0;
        }
        return totalWater;
    }
}