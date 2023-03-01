class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        HashSet<Integer> visited = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        int result = 0;
        if (source == target)
            return 0;
        for (int i = 0; i < routes.length; i++) {
            for (int j = 0; j < routes[i].length; j++) {
                ArrayList<Integer> buses = map.getOrDefault(routes[i][j], new ArrayList<>());
                buses.add(i);
                map.put(routes[i][j], buses);
            }
        }
        q.offer(source);
        while (!q.isEmpty()) {
            int size = q.size();
            result++;
            for (int i = 0; i < size; i++) {
                int curr = q.poll();
                ArrayList<Integer> buses = map.get(curr);
                for (int bus : buses) {
                    if (visited.contains(bus))
                        continue;
                    visited.add(bus);
                    for (int j = 0; j < routes[bus].length; j++) {
                        if (routes[bus][j] == target)
                            return result;
                        q.offer(routes[bus][j]);
                    }
                }
            }
        }
        return -1;
    }
}