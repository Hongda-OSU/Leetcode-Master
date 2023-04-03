class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
        int max = 0, i = 0, n = pairs.length;
        while (i < n) {
            max++;
            int end = pairs[i][1];
            while (i < n && pairs[i][0] <= end)
                i++;
        }
        return max;
    }
}