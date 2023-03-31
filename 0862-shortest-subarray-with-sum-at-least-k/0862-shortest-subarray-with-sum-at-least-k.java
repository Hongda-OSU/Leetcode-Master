class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length, result = n + 1;
        long[] arr = new long[n + 1];
        for (int i = 0; i < n; i++)
            arr[i + 1] = arr[i] + nums[i];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < n + 1; i++) {
            while (deque.size() > 0 && arr[i] - arr[deque.getFirst()] >= k)
                result = Math.min(result, i - deque.pollFirst());
            while (deque.size() > 0 && arr[i] <= arr[deque.getLast()])
                deque.pollLast();
            deque.addLast(i);
        }
        return result <= n ? result : -1;
    } 
}