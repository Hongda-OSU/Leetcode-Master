class Solution {
   int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int shortestPathAllKeys(String[] grid) {
        int m = grid.length, n = grid[0].length();
        int si = -1, sj = -1, k = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c = grid[i].charAt(j);
                if (c == '@') {
                    si = i;
                    sj = j;
                }
                if (isKey(c)) k++;
            }
        }
        Node start = new Node(si, sj, 0);
        Queue<Node> q = new LinkedList<>();
        q.offer(start);
        Set<String> visited = new HashSet<>();
        visited.add(si + " " +  sj + " " + 0);
        int level = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node cur = q.poll();
                if (cur.key == (1 << k) - 1) return level;
                for (int[] d : dirs) {
                    int x = cur.i + d[0];
                    int y = cur.j + d[1];
                    int key = cur.key;
                    if (!isValid(grid, x, y, m, n)) continue;
                    char c = grid[x].charAt(y);
                    if (isKey(c)) key |= (1 << (c - 'a'));
                    if (isLock(c) && (key >> (c - 'A') & 1) == 0) continue;
                    if (visited.add(x + " " + y + " " + key)) q.offer(new Node(x, y, key));
                }
            }
            level++;
        }
        return -1;
    }

    private boolean isLock(char c) {
        return c >= 'A' && c <= 'F';
    }

    private boolean isKey(char c) {
        return c >= 'a' && c <= 'f';
    }

    private boolean isValid(String[] grid, int i, int j, int m, int n) {
        return i >= 0 && i < m && j >= 0 && j < n && grid[i].charAt(j) != '#';
    }

    class Node {
        int i, j, key;
        public Node(int i, int j, int key) {
            this.i = i;
            this.j = j;
            this.key = key;
        }
    }
}