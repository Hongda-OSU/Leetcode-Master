class Solution {
    public int minKBitFlips(int[] nums, int k) {
        boolean[] flipped = new boolean[nums.length];
        int flipCount = 0, flipTimes = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i >= k) {
                if (flipped[i - k]) 
                    flipTimes--;
            }
            if (flipTimes % 2 == nums[i]) {
                if (i + k > nums.length)
                    return -1;
                flipTimes++;
                flipped[i] = true;
                flipCount++;
            }
        }
        return flipCount;
    }
}