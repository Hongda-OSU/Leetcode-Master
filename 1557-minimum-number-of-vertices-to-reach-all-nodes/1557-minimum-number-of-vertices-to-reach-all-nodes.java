class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        List<Integer> result = new ArrayList<>();
        boolean[] reachable = new boolean[n];
        for (List<Integer> edge : edges) 
            //get 'to' node from the edge and set the reachable flag for it 
            reachable[edge.get(1)] = true;
        for (int i = 0; i < n; i++) {
            if (!reachable[i])
                result.add(i);
        }
        return result;
    }
}