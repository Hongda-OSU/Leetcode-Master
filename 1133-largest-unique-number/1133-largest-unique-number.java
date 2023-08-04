class Solution {
    public int largestUniqueNumber(int[] nums) {
        int[] frequency = new int[1001];
        for (int num : nums)
            frequency[num]++;
        for (int i = frequency.length - 1; i >= 0; i--) {
            if (frequency[i] == 1)
                return i;
        }
        return -1;
    }
}