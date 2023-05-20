class Solution {
    /**
    Very similar to 815 especially the bit part.
    Our state defined as {currentNode, visitedNodeBit}
    When node 1,2,4 has been visited, we use 10110 to represent. (node 0 and 3 are not visited)
    Add all nodes to bfsQueue initially and run BFS.
    When visitedNodeBit = 11111..111 (however many nodes/bit). We find the ans.
    Time/Space complexity: O(n*2^n)
    */
    public int shortestPathLength(int[][] graph) {
        if(graph.length==1)
            return 0;
        int ansBit = (1 << graph.length) - 1;
        int [][] visitedMap = new int [graph.length][ansBit+1]; //[How many nodes][each node may have 2^n visited bit]
        Queue<int []> bfsQueue = new LinkedList<>();
        for(int i=0; i<graph.length; i++)
            bfsQueue.add(new int [] {i, 1 << i}); //Adding all nodes initially because we can start anywhere.
        int shortestPath = 0;
        while(!bfsQueue.isEmpty()){
            int size = bfsQueue.size();
            shortestPath++;
            for(int i=0; i<size; i++){
                int [] state = bfsQueue.poll();
                int nodeNum = state[0];
                int visitedNodeBit = state[1];
                for(int neighbors : graph[nodeNum]){
                    int newVisitedNodeBit = visitedNodeBit | (1 << neighbors);//Adding neighbor node to visitedNodeBit. Add 2^nodeNum using bit OR.  001 | 010 --> 011. Visited node 0 and 1. 
                    if(visitedMap[neighbors][newVisitedNodeBit] == 1) //If the same node was visited again with same visitedNodeBit, it means this node doesn't
                        continue;//need to be visited again.  For example: 1->0->1->0.  First 1 we have {1, 10}, then we have {0, 11}, then we will have {1, 11}.
                    visitedMap[neighbors][newVisitedNodeBit] = 1;//Lastly, we have {0, 11} which is a state we already had before. So we don't visit this again.
                    if(newVisitedNodeBit==ansBit)  
                        return shortestPath;
                    bfsQueue.add(new int [] {neighbors, newVisitedNodeBit});
                }   
            }
        }
        return -1;
    }
}