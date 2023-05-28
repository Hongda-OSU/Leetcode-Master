class TreeAncestor {
    private int[][] values;
    private int[] index, offset;

    public TreeAncestor(int n, int[] parent) {
        index = new int[n];
        offset = new int[n];
        int[] t = new int[n];
        int len = 0;
        for (int i = 1; i < n; i++) {
            if (t[parent[i]] == 0)
                len++;
            t[parent[i]]--;
        }
        values = new int[n - len][0];
        int[] temp = new int[n];
        len = 0;
        for (int i = 0; i < n; i++) {
            if (t[i] == 0) {
                init(parent, temp, 0, len, i);
                len++;
            }
        }
    }
    
    public int getKthAncestor(int node, int k) {
        int idx = index[node];
        int off = offset[node];
        if (off + k >= values[idx].length)
            return -1;
        return values[idx][off + k];
    }
    
    private void init(int[] parent, int[] temp, int idx, int base, int curr) {
        if (curr == -1) {
            int[] nums = new int[idx];
            System.arraycopy(temp, 0, nums, 0, idx);
            values[base] = nums;
            return;
        }
        if (offset[curr] > 0) {
            int ol = values[index[curr]].length - offset[curr];
            int[] nums = new int[idx + ol];
            System.arraycopy(temp, 0, nums, 0, idx);
            System.arraycopy(values[index[curr]], offset[curr], nums, idx, ol);
            values[base] = nums;
            return;
        }
        offset[curr] = idx;
        index[curr] = base;
        temp[idx] = curr;
        init(parent, temp, idx + 1, base, parent[curr]);
    }
}

/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */