class Solution {
    public int makeConnected(int n, int[][] connections) {
        int[] c = new int[n];
        int group = 0, extra = 0;
        for (int i = 0; i < n; i++)
            c[i] = i;
        for (int[] connection : connections) {
            if (union(connection[0], connection[1], c)) 
                extra++;
        }
        for (int j = 0; j < n; j++) {
            if (find(j, c) == j)
                group++;
        }
        return extra >= group - 1 ? group - 1 : -1;
    }
    
    public boolean union(int c1, int c2, int[] c) {
        if (find(c1, c) != find(c2, c)) {
            c[c[c1]] = c[c2];
            return false;
        } 
        return true;
    }
    
    public int find(int index, int[] c) {
        if (c[index] != index) 
            c[index] = find(c[index], c);
        return c[index];
    }
}