class Solution {
    public int jump(int[] nums) {
        // The starting range of the first jump is [0, 0]
        int step = 0, end = 0, far = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            // Update the farthest reachable index of this jump.
            far = Math.max(far, i + nums[i]);
            // If we finish the starting range of this jump,
            // Move on to the starting range of the next jump.
            if (i == end) {
                step++;
                end = far;
            }
        }
        return step;
    }
}