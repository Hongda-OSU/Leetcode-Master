class Solution {
    public int findIntegers(int n) {
        int[] arr = new int[32];
        arr[0] = 1;
        arr[1] = 2;
        for (int i = 2; i < arr.length; i++) 
            arr[i] = arr[i - 1] + arr[i - 2];
        int i = 30, sum = 0, prev = 0;
        while (i >= 0) {
            if ((n & (1 << i)) != 0) {
                sum += arr[i];
                if (prev == 1) {
                    sum--;
                    break;
                }
                prev = 1;
            } else {
                prev = 0;
            }
            i--;
        }
        return sum + 1;
    }
}