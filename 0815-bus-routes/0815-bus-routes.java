class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        //Create a hashMap for access inverted mappings
        //Bus Stop(Integer) -> Bus Number(ArrayList<Integer>)
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            for (int j = 0; j < routes[i].length; j++) {
                int busStop = routes[i][j];
                ArrayList<Integer> busNo = map.getOrDefault(busStop, new ArrayList<>());
                busNo.add(i);
                map.put(busStop, busNo);
            }
        }
        //we need a queue for BFS
        LinkedList<Integer> queue = new LinkedList<>();
        //we need a hashSet to keep track of Bus Stops visited
        HashSet<Integer> busStopVisited = new HashSet<>();
        //store the bus number to keep track of all bus stops visited for a bus number.
        HashSet<Integer> busVisited = new HashSet<>();
        int cost = 0;
        //add source to the queue and make it visited
        queue.addLast(source);
        busStopVisited.add(source);
        //start BFS
        while (queue.size() > 0) {
            int size = queue.size();
            while (size > 0) {
                int rem = queue.removeFirst();
                // if the removed bus stop is equal to our target bus stop, then return the cost
                if (rem == target) return cost;
                //use the hashmap to get the list of buses we can get form the bus stop on which we currently stand
                ArrayList<Integer> buses = map.get(rem);
                //think as if we are trying to catch and explore a new bus from the bus stop on which we are
                for (int bus : buses) {
                    //already visited then don't do anything, just continue to explore new buses
                    if (busVisited.contains(bus)) continue;
                    //new bus found, catch this bus and see where can you reach target from this bus
                    int[] stops = routes[bus];
                    for (int busStop : stops) {
                        if (busStopVisited.contains(busStop)) continue;
                        queue.addLast(busStop);
                        busStopVisited.add(busStop);
                    }
                    busVisited.add(bus);
                }
                size--;
            }
            cost++;
        }
        return -1;
    }
}