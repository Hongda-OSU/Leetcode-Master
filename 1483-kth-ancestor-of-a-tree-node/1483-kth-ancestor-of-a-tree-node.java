class TreeAncestor {

        int[][] values;

        int[] reIndex;

        int[] offset;

        public TreeAncestor(int n, int[] parent) {
            reIndex = new int[n];
            offset = new int[n];
            int[] t = new int[n];
            int len = 0;
            for (int i = 1; i < n; i++) {
                if (t[parent[i]] == 0) {
                    len++;
                }
                t[parent[i]]--;
            }
            len = n - len;
            values = new int[len][0];
            int[] temp = new int[n];
            len = 0;
            for (int i = 0; i < n; i++) {
                if (t[i] == 0) {
                    init(parent, temp, 0, len, i);
                    len++;
                }
            }
        }

        private void init(int[] parent, int[] temp, int index, int base, int cur) {
            if (cur == -1) {
                int[] nums = new int[index];
                System.arraycopy(temp, 0, nums, 0, index);
                values[base] = nums;
                return;
            }
            if (offset[cur] > 0) {
                int ol = values[reIndex[cur]].length - offset[cur];
                int[] nums = new int[index + ol];
                System.arraycopy(temp, 0, nums, 0, index);
                System.arraycopy(values[reIndex[cur]], offset[cur], nums, index, ol);
                values[base] = nums;
                return;
            }
            offset[cur] = index;
            reIndex[cur] = base;
            temp[index] = cur;
            init(parent, temp, index + 1, base, parent[cur]);
        }

        public int getKthAncestor(int node, int k) {
            int index = reIndex[node];
            int off = offset[node];
            if (off + k >= values[index].length) {
                return -1;
            }
            return values[index][off + k];
        }
    }

/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */