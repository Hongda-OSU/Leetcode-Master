class Solution {
    public int minWastedSpace(int[] packages, int[][] boxes) {
        Arrays.sort(packages);
        long infinity = (long)1e11, result = infinity, mod = (long)1e9 + 7, sum = 0;
        for (int p : packages)
            sum += p;
        for (int[] box : boxes) {
            Arrays.sort(box);
            if (box[box.length - 1] < packages[packages.length - 1])
                continue;
            long curr = 0, i = 0;
            for (int b : box) {
                int j = binarySearch(packages, b + 1);
                curr += b * (j - i); 
                i = j;
            }
            result = Math.min(result, curr);
        }
        return result < infinity ? (int)((result - sum) % mod) : -1;
    }
    
    public int binarySearch(int[] packages, int target) {
        int left = 0, right = packages.length;
        while (left < right) {
            int pivot = (left + right) >>> 1;
            if (packages[pivot] < target)
                left = pivot + 1;
            else 
                right = pivot;
        }
        return left;
    }
}