class Solution {
    public int earliestAcq(int[][] logs, int n) {
        Arrays.sort(logs, (a, b) -> a[0] - b[0]);
        int[] group = new int[n], size = new int[n];
        for (int i = 0; i < n; i++) {
            group[i] = i;
            size[i] = 1;
        }
        for (int[] log : logs) {
            int f1 = find(group, log[1]);
            int f2 = find(group, log[2]);
            if (f1 != f2) {
                union(size, group, f1, f2);
                if (--n == 1)
                    return log[0];
            }
        }
        return -1;
    }
    
    public void union(int[] size, int[] group, int i, int j) {
        if (size[i] < size[j])
            union(size, group, j, i);
        group[j] = i;
        size[i] += size[j];
    }
    
    public int find(int[] group, int x) {
        while (group[x] != x) {
            group[x] = group[group[x]];
            x = group[x];
        }
        return group[x];
    }
} 