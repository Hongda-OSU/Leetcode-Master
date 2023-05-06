class Solution {
    public int deleteTreeNodes(int nodes, int[] parent, int[] value) {
        int[] degree = new int[nodes], size = new int[nodes];
        for (int i = 1; i < nodes; i++) {
            ++degree[parent[i]];
            size[i] = 1;
        }
        size[0] = 1;
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < nodes; i++) {
            if (degree[i] == 0)
                queue.offer(i);
        }
        while (!queue.isEmpty()) {
            int i = queue.poll();
            if (i == 0) {
                if (value[0] == 0) 
                    count += size[0];
                break;
            }
            if (value[i] == 0)
                count += size[i];
            else 
                size[parent[i]] += size[i];
            value[parent[i]] += value[i];
            --degree[parent[i]];
            if (degree[parent[i]] == 0)
                queue.offer(parent[i]);
        } 
        return nodes - count;
    }
}