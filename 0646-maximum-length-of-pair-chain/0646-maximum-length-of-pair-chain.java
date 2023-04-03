class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
        int len = 0, prev = Integer.MIN_VALUE;
        for (int[] pair : pairs) {
            if (pair[0] > prev) {
                len++;
                prev = pair[1];
            } 
        }
        return len;
    }
}