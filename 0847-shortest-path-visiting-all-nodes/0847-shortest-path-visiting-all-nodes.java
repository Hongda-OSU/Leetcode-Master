class Solution {
    public int shortestPathLength(int[][] graph) {
        int len = graph.length;
        
        if(len == 1)
            return 0;
        
        int target = (1 << len) - 1;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] dp = new boolean[len][target + 1];
        int covered = 0;
        int minDegree = Integer.MAX_VALUE;
        int firstIndex = -1;
        
        for(int[] arr : graph){
            minDegree = Math.min(minDegree, arr.length); // get the min degree a node has
        }
        
        for(int i = 0; i < graph.length; i++)
            if(graph[i].length == minDegree)
                q.add(new int[]{i, 1 << i}); // add all nodes with the minimum degree, no need to consider all nodes
        
        while(!q.isEmpty()){
            int size = q.size();
            covered++;
            while(size-- > 0){
                int[] temp = q.remove();
                int index = temp[0];
                int val = temp[1];
                
                for(int nextIndex : graph[index]){
                    int newVal = val | (1 << nextIndex);
                    if(newVal == target)
                        return covered;
                    if(!dp[nextIndex][newVal]){
                        q.add(new int[]{nextIndex, newVal});
                        dp[nextIndex][newVal] = true;
                    }
                }
            }
        }
        return -1;
    }
}