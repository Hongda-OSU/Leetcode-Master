class Solution {
    public int[] assignBikes(int[][] workers, int[][] bikes) {
        int n = workers.length;
        Queue<int[]> q = new PriorityQueue<int[]>((a, b)->(a[0] == b[0] ? (a[1] == b[1] ? a[2] - b[2] : a[1] - b[1]) : a[0] - b[0]));
        int i = 0;
        for (int[] worker : workers) {
            int j = 0;
            for (int[] bike : bikes) {
               q.add(new int[]{Math.abs(bike[0] - worker[0]) + Math.abs(bike[1] - worker[1]), i, j++}); 
            }
            i++;
        }
        int[] res = new int[n];
        Arrays.fill(res, -1);
        Set<Integer> visited = new HashSet<>();
        while (visited.size() < n) {
            int[] temp = q.poll();
            if (res[temp[1]] == -1 && !visited.contains(temp[2])) {   
                res[temp[1]] = temp[2];
                visited.add(temp[2]);
            }
        }
        return res;
    }
}