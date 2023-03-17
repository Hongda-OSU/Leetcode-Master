class Solution {
    public int shortestPathAllKeys(String[] grid) {
        int x = -1, y = -1, m = grid.length, n = grid[0].length(), max = -1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char ch = grid[i].charAt(j);
                if (ch == '@') {
                    x = i;
                    y = j;
                }
                if (ch >= 'a' && ch <= 'f')
                    max = Math.max(ch - 'a' + 1, max);
            }
        }
        State start = new State(x, y, 0);
        Queue<State> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        visited.add(0 + " " + x + " " + y);
        queue.offer(start);
        int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                State curr = queue.poll();
                if (curr.keys == (1 << max) - 1)
                    return steps;
                for (int[] dir : dirs) {
                    int i = curr.i + dir[0], j = curr.j + dir[1];
                    int keys = curr.keys;
                    if (i >= 0 && i < m && j >= 0 && j < n) {
                        char ch = grid[i].charAt(j);
                        if (ch == '#')
                            continue;
                        if (ch >= 'a' && ch <= 'f')
                            keys |= 1 << (ch - 'a');
                        if (ch >= 'A' && ch <= 'F' && ((keys >> (ch - 'A')) & 1) == 0)
                            continue;
                        if (!visited.contains(keys + " " + i + " " + j)) {
                            visited.add(keys + " " + i + " " + j);
                            queue.offer(new State(i, j, keys));
                        }
                    }
                }
            } 
            steps++;
        }
        return -1;
    }
}

class State {
    public int i, j, keys;
    
    public State(int i, int j, int keys) {
        this.i = i;
        this.j = j;
        this.keys = keys;
    }
}