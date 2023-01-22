class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // build the adjacency list, with each course acting as a node.
        List<Integer>[] adjacent = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) adjacent[i] = new ArrayList<>();
        for (int j = 0; j < prerequisites.length; j++) adjacent[prerequisites[j][0]].add(prerequisites[j][1]);
        // this array is to track the visited nodes, initially all nodes are in state 0 (unvisisted).
        int[] visited = new int[numCourses];
        List<Integer> list = new ArrayList<>();
        // perform dfs on each node in the graph as the graph may not be fully connected.
        for (int i = 0; i < adjacent.length; i++) {
            if (visited[i] == 0) {
                // if cycle found from any node return an empty array.
                if (topoSort(i, list, adjacent, visited) == false)
                    return new int[0];
            }
        }
        // if no cycles were found we can copy the ArrayList over to an array and return.
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
    
    public boolean topoSort(int index, List<Integer> list, List<Integer>[] adjacent, int[] visited) {
        visited[index] = 1; // mark the current node with state 1 (visiting).
        List<Integer> neighbors = adjacent[index]; // get all neighbouring nodes.
        for (Integer i : neighbors) {
            // if one of the neighbours is also being visited then there is a cycle.
            if (visited[i] == 1) return false;
            if (visited[i] == 0) {
                // perform top sort on all unvisisted neighbours.
                if (topoSort(i, list, adjacent, visited) == false) return false;
            }
        }
        // mark current node with state 2 (visited) and add it to the list holding the result.
        visited[index] = 2;
        list.add(index);
        return true;
    }
}