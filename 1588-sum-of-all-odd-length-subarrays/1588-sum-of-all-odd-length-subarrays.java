class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int n = arr.length, sum = 0;
        for (int i = 0; i < n; i++) {
            int start = n - i;
            int end = i + 1;
            int target = start * end;
            int odd = target / 2;
            if (target % 2 == 1)
                odd++;
            sum += odd * arr[i];
        }
        return sum;
    }
}