class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        PriorityQueue<int[]> tasks = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (int i = 0; i < profit.length; i++)
            tasks.offer(new int[]{difficulty[i], profit[i]});
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int w : worker)
            pq.offer(w);
        int sum = 0;
        while (!pq.isEmpty() && !tasks.isEmpty()) {
            if (pq.peek() >= tasks.peek()[0]) {
                while(!pq.isEmpty() && tasks.peek()[0] <= pq.peek()) {
                    sum += tasks.peek()[1];
                    pq.poll();
                }
            } else {
                while(!tasks.isEmpty() && tasks.peek()[0] > pq.peek())
                    tasks.poll();
            }
        }
        return sum;
    }
}