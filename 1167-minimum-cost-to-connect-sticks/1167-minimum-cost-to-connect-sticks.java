class Solution {
    public int connectSticks(int[] sticks) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int stick : sticks) 
            pq.offer(stick);
        int sum = 0;
        while (pq.size() > 1) {
            int temp = pq.poll() + pq.poll();
            sum += temp;
            pq.offer(temp);
        }
        return sum;
    }
}