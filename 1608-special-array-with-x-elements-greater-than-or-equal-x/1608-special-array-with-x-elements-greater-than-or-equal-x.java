class Solution {
    public int specialArray(int[] nums) {
        int n = nums.length;
        // Bucket sort Time: O(N), Space: O(N)
        // Count #occurences for each number within 0 - nums.length
        // Counts[1] = #occurences of 1
        // Counts[i] = #occurences of i
        // ...
        // while counts[counts.length - 1] store the #occurences for all numbers >= counts.length - 1
        // numOfElements is the max possible answer, so no need to count #occurences for each number >= numOfElements
        int[] counts = new int[n + 1];
        for (int num : nums) {
            if (num >= n)
                counts[n]++;
            else 
                counts[num]++;
        }
        // Reverse order
        // Consider the index i as x, and the goal is to find when (res = current number of elements >= x) == x 
        int result = 0;
        for (int i = counts.length - 1; i > 0; i--) {
            result += counts[i];
            if (result == i)
                return i;
        }
        return -1;
    } 
}