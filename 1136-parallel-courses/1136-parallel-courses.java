class Solution {
    public int minimumSemesters(int N, int[][] relations) {        
    Map<Integer, List<Integer>> graph = new HashMap<>();  // Maps a course to a list of courses that have it as a prerequisite.  
    Map<Integer, Integer> inDegree = new HashMap<>();     // Maps a node to the number of its remaining prerequisites.
    for (int i = 1; i <= N; ++i) {
        graph.put(i, new ArrayList<>());
        inDegree.put(i, 0);
    }
    for (int[] edge : relations) {
        // We assume that there are no duplicate edges.
        graph.get(edge[0]).add(edge[1]);
        inDegree.put(edge[1], inDegree.get(edge[1]) + 1);
    }
    
    Deque<Integer> queue = new ArrayDeque<>();
    // Add all courses with no prerequisites. These are all the courses that can be done in the first semester.
    for (int i = 1; i <= N; ++i) {
        if (inDegree.get(i) == 0) queue.addLast(i);
    }
    
    int result = 0, finishedCourses = 0; 
    while (queue.size() > 0) {
        // All courses that are currently in the queue can be done in the current semester.
        finishedCourses += queue.size();
        result++;
        for (int i = queue.size(); i > 0; --i) {
            int currCourse = queue.removeFirst();
            // Finish currCourse and remove it as a prerequisite. Add courses that now have 0 prerequisites to the queue.
            for (int adjacentNode : graph.get(currCourse)) {
                inDegree.put(adjacentNode, inDegree.get(adjacentNode) - 1);
                if (inDegree.get(adjacentNode) == 0) queue.addLast(adjacentNode);
            }
        }    
    }
    return finishedCourses == N ? result : -1;
}
}