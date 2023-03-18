class Solution {
    public int minSwaps(int[] data) {
        int ones = Arrays.stream(data).sum();
        int count = 0, max = 0, left = 0, right = 0;
        while (right < data.length) {
            count += data[right++];
            if (right - left > ones)
                count -= data[left++];
            max = Math.max(max, count);
        }
        return ones - max;
    }
}