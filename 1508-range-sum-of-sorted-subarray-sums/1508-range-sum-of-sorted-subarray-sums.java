class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        int mod = 1_000_000_007;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.sum - b.sum);
        for (int i = 0; i < n; i++)
            pq.offer(new Pair(nums[i], i));
        left--;
        right--;
        int result = 0;
        for (int j = 0; j <= right; j++) {
            Pair p = pq.poll();
            if (j >= left)
                result = (result % mod + p.sum % mod) % mod;
            if (p.index < n - 1) {
                p.sum = (p.sum % mod + nums[p.index += 1] % mod) % mod;
                pq.offer(p);
            }
        }
        return result;
    }
}

class Pair {
    public int sum;
    public int index;
    
    public Pair(int sum, int index) {
        this.sum = sum;
        this.index = index;
    }
}