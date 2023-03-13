class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int n = arr.length - 1;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> arr[a[0]] * arr[b[1]] - arr[b[0]] * arr[a[1]]);
        for (int i = 0; i < n; i++)
            pq.add(new int[]{i, n});
        for (int i = 0; i < k - 1; i++) {
            int[] curr = pq.remove();
            int x = curr[0], y = curr[1];
            if (y - x > 1) {
                curr[1]--;
                pq.add(curr);
            }
        }
        int[] peek = pq.peek();
        return new int[]{arr[peek[0]], arr[peek[1]]};
    }
}