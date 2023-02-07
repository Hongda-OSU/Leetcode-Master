class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int n = arr.length, sum = 0;
        for (int left = 0; left < n; left++) {
            int tmpSum = 0;
            for (int right = left; right < n; right++) {
                tmpSum += arr[right];
                // odd length window
                sum += (right - left + 1) % 2 == 1 ? tmpSum : 0;
            }
        }
        return sum;
    }
}