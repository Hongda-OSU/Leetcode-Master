class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        int[] result = new int[2];
        int minX = Integer.MAX_VALUE, maxY = Integer.MIN_VALUE, minRange = Integer.MAX_VALUE;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i).get(0) > maxY)
                maxY = nums.get(i).get(0);
            pq.offer(new int[] {nums.get(i).get(0), i, 0});
        }
        while (!pq.isEmpty()) {
            int[] min = pq.poll();
            int i = min[1], j = min[2];
            if (maxY - min[0] < minRange) {
                minRange = maxY - min[0];
                result[0] = min[0];
                result[1] = maxY;
            }
            if (i < nums.size() && j + 1 < nums.get(i).size()) {
                pq.offer(new int[] {nums.get(i).get(j + 1), i, j + 1});
                if (nums.get(i).get(j + 1) > maxY)
                    maxY = nums.get(i).get(j + 1);
            } else 
                break;
        }
        return result;
    }
}