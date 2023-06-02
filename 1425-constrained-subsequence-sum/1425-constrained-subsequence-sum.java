class Solution {
   public int constrainedSubsetSum(int[] arr, int k) {
        int n = arr.length;
        Deque<Integer> deque = new LinkedList<>();
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
			int max = Math.max(0, deque.isEmpty() ? 0 : arr[deque.peekFirst()]);
            arr[i] += max;
            ans = Math.max(ans, arr[i]);
            while (!deque.isEmpty() && arr[i] >= arr[deque.peekLast()]) { // If dp[i] >= deque.peekLast() -> Can discard the tail since it's useless
                deque.pollLast();
            }
            deque.addLast(i);
            if (i - deque.peekFirst() + 1 > k) { // remove the last element of range k
                deque.removeFirst();
            }
        }
        return ans;
    }
}