class Solution {
    private int[] dx = new int[]{0, 0, 1, -1};
    private int[] dy = new int[]{1, -1, 0, 0};
    
    public int shortestPathAllKeys(String[] grid) {
        int m = grid.length, n = grid[0].length();
        char[][] arr = new char[m][n];
        int x = -1, y = -1, k = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char ch = grid[i].charAt(j);
                arr[i][j] = ch;
                if (ch == '@') {
                    x = i;
                    y = j;
                } else if (ch >= 'a' && ch <= 'f') {
                    k++;
                }
            }
        }
        int keys = 0, count = 0;
        for (int i = 0; i < k; i++)
            keys = addKey(keys, 'a' + i);
        Queue<Node> queue = new LinkedList<>();
        boolean[][][] visited = new boolean[m][n][keys + 1];
        queue.offer(new Node(x, y, 0));
        visited[x][y][0] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node curr = queue.poll();
                if (curr.keys == keys)
                    return count;
                for (int j = 0; j < 4; j++) {
                    x = curr.x + dx[j];
                    y = curr.y + dy[j];
                    if (x < 0 || x >= m || y < 0 || y >= n || arr[x][y] == '#') 
                        continue;
                    char ch = arr[x][y];
                    int ks = addKey(curr.keys, ch);
                    if (visited[x][y][ks])
                        continue;
                    if (ch >= 'A' && ch <= 'F' && !unlock(curr.keys, ch))
                        continue;
                    visited[x][y][ks] = true;
                    queue.offer(new Node(x, y, ks));
                }
            }
            count++;
        }
        return -1;
    }
    
    public int addKey(int keys, int ch) {
        if (ch >= 'a' && ch <= 'f') {
            int idx = ch - 'a';
            return keys | (1 << idx);
        }
        return keys;
    }
    
    public boolean unlock(int keys, int ch) {
        int idx = ch - 'a';
        return (keys & (1 << idx)) > 0;
    }
}

class Node {
    public int x, y, keys;
    
    public Node(int x, int y, int keys) {
        this.x = x;
        this.y = y;
        this.keys = keys;
    }
}