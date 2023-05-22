class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int[] arr = new int[n * n];
        int i = n - 1, j = 0, index = 0, inc = 1;
        while (index < n * n) {
            arr[index++] = board[i][j];
            if (inc == 1 && j == n - 1) {
                inc = -1;
                i--;
            } else if (inc == -1 && j == 0) {
                inc = 1;
                i--;
            } else {
                j += inc;
            }
        }
        boolean[] visited = new boolean[n * n];
        Queue<Integer> queue = new LinkedList<>();
        int start = arr[0] > -1 ? arr[0] - 1 : 0;
        queue.offer(start);
        visited[start] = true;
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int curr = queue.poll();
                if (curr == n * n - 1)
                    return step;
                for (int next = curr + 1; next <= Math.min(curr + 6, n * n - 1); next++) {
                    int dest = arr[next] > -1 ? arr[next] - 1 : next; 
                    if (!visited[dest]) {
                        visited[dest] = true;
                        queue.offer(dest);
                    }
                }
            }
            step++;
        }
        return -1;
    }
}