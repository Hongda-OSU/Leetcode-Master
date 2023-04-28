class Solution {
    public int maxCoins(int[] nums) {
        int nlen = nums.length;
        int[] arr = new int[nlen + 2];
        int alen = arr.length;
        for (int i = 1; i <= nlen; i++)
            arr[i] = nums[i - 1];
        arr[0] = 1;
        arr[nlen + 1] = 1;
        int sum[][] = new int[alen][alen];
        for (int gap = 0; gap < nlen; gap++) {
            for (int begin = 1; begin < nlen - gap + 1; begin++) {
                int end = begin + gap;
                sum[begin][end] = Integer.MIN_VALUE;
                int left = arr[begin - 1];
                int right = arr[end + 1];
                sum[begin][end] = Math.max(sum[begin][end], sum[begin + 1][end] + arr[begin] * left * right);
                sum[begin][end] = Math.max(sum[begin][end], sum[begin][end - 1] + arr[end] * left * right);
                for (int j = begin + 1; j < end; j++)
                    sum[begin][end] = Math.max(sum[begin][end], sum[begin][j - 1] + sum[j + 1][end] + arr[j] * left * right);
            }
        }
        return sum[1][nums.length];
    }
}