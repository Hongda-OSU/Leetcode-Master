class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
        int result = nums[0], n = nums.length;
        Deque<Tuple> deque = new ArrayDeque<>();
        deque.offerLast(new Tuple(nums[0], 0));
        for (int i = 1; i < n; i++) {
            if (i - deque.peekFirst().idx > k) 
                deque.pollFirst();
            int curr = Math.max(nums[i], deque.peekFirst().sum + nums[i]);
            while (!deque.isEmpty() && deque.peekLast().sum <= curr) 
                deque.pollLast();
            deque.offerLast(new Tuple(curr, i));
            result = Math.max(curr, result);
        }
        return result;
    }
}

class Tuple {
    public int sum, idx;
    
    public Tuple(int sum, int idx) {
        this.sum = sum;
        this.idx = idx;
    }
}