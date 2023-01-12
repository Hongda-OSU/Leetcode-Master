class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int stone : stones)
            pq.add(stone);
        while (pq.size() > 1) {
            int s1 = pq.poll();
            int s2 = pq.poll();
            if (s1 == s2) continue;
            else pq.add(Math.abs(s1 - s2));
        }
        return pq.size() == 0 ? 0 : pq.poll();
    }
}