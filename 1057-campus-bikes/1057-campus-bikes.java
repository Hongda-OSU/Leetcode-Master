class Solution {
    // List of pairs (distance, bike index) for each bike corresponding to worker
    List<List<Pair<Integer, Integer>>> workerToBikeList = new ArrayList<>();
    // Stores the closest bike index, corresponding to the worker index
    int closestBikeIndex[] = new int[1001];
    
    // Class to store (worker, bike, distance)
    class WorkerBikePair {
        int workerIndex;
        int bikeIndex;
        int distance;   
        
        // Constructor to initialize the member variables
        WorkerBikePair(int workerIndex, int bikeIndex, int distance) {
            this.workerIndex = workerIndex;
            this.bikeIndex = bikeIndex;
            this.distance = distance;
        }
    }
    
    // Custom comparator for comparing WorkerBikePair in priority queue
    Comparator<WorkerBikePair> WorkerBikePairComparator 
        = new Comparator<WorkerBikePair>() {
        @Override
        public int compare(WorkerBikePair a, WorkerBikePair b) {
            if (a.distance != b.distance) {
                // Prioritize the one having smaller distance
                return a.distance - b.distance;
            } else if (a.workerIndex != b.workerIndex) {
                // Prioritize according to the worker index
                return a.workerIndex - b.workerIndex;
            } else {
                // Prioritize according to the bike index
                return a.bikeIndex - b.bikeIndex;
            }
        }
    };

    // Function to return the Manhattan distance
    int findDistance(int[] worker, int[] bike) {
        return Math.abs(worker[0] - bike[0]) + Math.abs(worker[1] - bike[1]);
    }
    
    // Add the closest bike for the worker to the priority queue, 
    // And update the closest bike index
    void addClosestBikeToPq(PriorityQueue<WorkerBikePair> pq, int worker) {
        Pair<Integer, Integer> closestBike = workerToBikeList.get(worker)
            .get(closestBikeIndex[worker]);
        closestBikeIndex[worker]++;
        
        WorkerBikePair workerBikePair 
            = new WorkerBikePair(worker, closestBike.getValue(), closestBike.getKey());
        pq.add(workerBikePair);
    }
    
    public int[] assignBikes(int[][] workers, int[][] bikes) {
        PriorityQueue<WorkerBikePair> pq = new PriorityQueue<>(WorkerBikePairComparator);
        
        // Add all the bikes along with their distances from the worker
        for (int worker = 0; worker < workers.length; worker++) {
            List<Pair<Integer, Integer>> bikeList = new ArrayList<>();
            for (int bike = 0; bike < bikes.length; bike++) {
                int distance = findDistance(workers[worker], bikes[bike]);
                bikeList.add(new Pair(distance, bike));
            }
            Collections.sort(bikeList, Comparator.comparing(Pair::getKey));
            
            // Store all the bike options for the current worker in workerToBikeList
            workerToBikeList.add(bikeList);
            
             // First bike is the closest bike for each worker
            closestBikeIndex[worker] = 0;
            
            // For each worker, add their closest bike to the priority queue
            addClosestBikeToPq(pq, worker);    
        }
        
        // Initialize all values to false, to signify no bikes have been taken
        boolean bikeStatus[] = new boolean[bikes.length];
        
        // Initialize all index to -1, to mark all the workers available
        int workerStatus[] = new int[workers.length];
        Arrays.fill(workerStatus, -1);
        
        // Until all workers have not been assigned a bike
        while (!pq.isEmpty()) {
            // Pop the pair with smallest distance
            WorkerBikePair workerBikePair = pq.remove();
            
            int worker = workerBikePair.workerIndex;
            int bike = workerBikePair.bikeIndex;
            
            if (workerStatus[worker] == -1 && !bikeStatus[bike]) {
                // If both worker and bike are free, assign them to each other
                bikeStatus[bike] = true;
                workerStatus[worker] = bike;
                
            } else {
                // Add the next closest bike for the current worker
                addClosestBikeToPq(pq, worker);
            }
        }
    
        return workerStatus;
    }
}