class Solution {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> result = new ArrayList<>();
        if (positions == null || positions.length == 0) {
            return result;
        }
        int[] root = new int[m * n];
        Arrays.fill(root, -1);
        int count = 0;
        int[] xDelta = {1, -1, 0, 0};
        int[] yDelta = {0, 0, 1, -1};
        for (int[] position : positions) {
            
            int x = position[0];
            int y = position[1];
            int index = x * n + y;
            if (root[index] != -1) {    // duplicate position
                result.add(count);
                continue;
            }
            count++;
            root[index] = index;
            for (int i = 0; i < 4; i++) {
                int r = x + xDelta[i];
                int c = y + yDelta[i];
                if (isValid(m, n, r, c, root)) {
                    int neighborIndex = r * n + c;
                    int neighborRoot = findRoot(root, neighborIndex);
                    if (neighborRoot != index) {
                        root[neighborRoot] = index;
                        count--;
                    }
                }
            }
            result.add(count);
        }
        return result;
    }
    
    private boolean isValid(int m, int n, int r, int c, int[] root) {
        if (r < 0 || c < 0 || r >= m || c >= n || root[r * n + c] == -1) {
            return false;
        }
        return true;
    }
    
    private int findRoot(int[] root, int index) {
        while (index != root[index]) {
            root[index] = root[root[index]];
            index = root[index];
        }
        return index;
    }
}