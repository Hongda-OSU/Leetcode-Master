class Solution {
    
    private int[] xd = new int[]{0, 0, 1, -1};
    private int[] yd = new int[]{1, -1, 0, 0};
    
    private class Node {
        int x;
        int y;
        int ks;
        public Node(int x, int y, int ks) {
            this.x = x;
            this.y = y;
            this.ks = ks;
        }
    }
    
    public int shortestPathAllKeys(String[] grid) {
        int m = grid.length;
        int n = grid[0].length();
        char[][] chars = new char[m][n];
        int x = -1, y = -1;
        int k = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c = grid[i].charAt(j);
                chars[i][j] = c;
                if (c == '@') {
                    x = i;
                    y = j;
                }
                else if (c >= 'a' && c <= 'f') {
                    k++;
                }
            }
        }
        int keys = 0;
        for (int i = 0; i < k; i++) {
            keys = addKey(keys, 'a' + i);
        }
        Queue<Node> queue = new LinkedList();
        boolean[][][] visited = new boolean[m][n][keys + 1];
        queue.offer(new Node(x, y, 0));
        visited[x][y][0] = true;
        int cnt = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node curr = queue.poll();
                if (curr.ks == keys) {
                    return cnt;
                }
                for (int j = 0; j < 4; j++) {
                    x = curr.x + xd[j];
                    y = curr.y + yd[j];
                    if (x < 0 || x >= m || y < 0 || y >= n || chars[x][y] == '#') {
                        continue;
                    }
                    char c = chars[x][y];
                    int ks = addKey(curr.ks, c);
                    if (visited[x][y][ks]) {
                        continue;
                    }
                    if (c >= 'A' && c <= 'F' && !unlock(curr.ks, c)) {
                        continue;
                    }
                    visited[x][y][ks] = true;
                    queue.offer(new Node(x, y, ks));
                }
            }
            cnt++;
        }
        return -1;
    }
    
    public int addKey(int keys, int c) {
        if (c >= 'a' && c <= 'f') {
            int index = c - 'a';
            return keys | (1 << index);
        }
        return keys;
    }
    
    public boolean unlock(int keys, int c) {
        int index = c - 'A';
        return (keys & (1 << index)) > 0;
    }
}