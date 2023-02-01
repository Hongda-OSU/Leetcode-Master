class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> heap = 
            new PriorityQueue<>((a, b) -> (b[0] * b[0] + b[1] * b[1]) - (a[0] * a[0] + a[1] * a[1]));
        for (int[] point : points) {
            heap.add(point);
            if (heap.size() > k)
                heap.poll();
        }
        return heap.toArray(new int[0][0]);
    }
}