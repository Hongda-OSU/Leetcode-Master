class Solution {
    public int oddEvenJumps(int[] arr) {
        int[] count = new int[100001];
        boolean[][] result = new boolean[2][arr.length];
        result[0][arr.length - 1] = true;
        result[1][arr.length - 1] = true;
        count[arr[arr.length - 1]] = arr.length;
        int min = arr[arr.length - 1], max = arr[arr.length - 1];
        int res = 1;
        for (int i = arr.length - 2; i >= 0; i--) {
            int nextSmallIdx = findNextSmall(count, min, max, arr[i]);
            int nextLargeIdx = findNextLarge(count, min, max, arr[i]);
            if (nextSmallIdx == -1)
                result[0][i] = false;
            else 
                result[0][i] = result[1][nextSmallIdx];
            if (nextLargeIdx == -1)
                result[1][i] = false;
            else 
                result[1][i] = result[0][nextLargeIdx];
            count[arr[i]] = i + 1;
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
            if (result[0][i])
                res++;
        }
        return res;
    }
    
    private int findNextSmall(int[] count, int min, int max, int val) {
        for (int i = val; i <= max; i++) {
            if (count[i] != 0)
                return count[i] - 1;
        }
        return -1;
    }
    
    private int findNextLarge(int[] count, int min, int max, int val) {
        for (int i = val; i >= min; i--) {
            if (count[i] != 0)
                return count[i] - 1;
        }
        return -1;
    }
}