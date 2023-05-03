class Solution {
    // Maximum value of mask will be 2^(Number of bikes)
    // And number of bikes can be 10 at max
    int memo [] = new int[1024];
    
    // Count the number of ones using Brian Kernighan’s Algorithm
    private int countNumOfOnes(int mask) {
        int count = 0;
        while (mask != 0) {
            mask &= (mask - 1);
            count++;
        } 
        return count;
    }
    
    // Manhattan distance
    private int findDistance(int[] worker, int[] bike) {
        return Math.abs(worker[0] - bike[0]) + Math.abs(worker[1] - bike[1]);
    }
    
    private int minimumDistanceSum(int[][] workers, int[][] bikes) {
        int numOfBikes = bikes.length;
        int numOfWorkers = workers.length;
        int smallestDistanceSum = Integer.MAX_VALUE;

        // 0 signifies that no bike has been assigned and
        // Distance sum for not assigning any bike is equal to 0
        memo[0] = 0;
        
        // Traverse over all the possible values of mask
        for (int mask = 0; mask < (1 << numOfBikes); mask++) {
            int nextWorkerIndex = countNumOfOnes(mask);
            
            // If mask has more number of 1's than the number of workers
            // Then we can update our answer accordingly
            if (nextWorkerIndex >= numOfWorkers) {
                smallestDistanceSum = Math.min(smallestDistanceSum, memo[mask]);
                continue;
            }
            
            for (int bikeIndex = 0; bikeIndex < numOfBikes; bikeIndex++) {
                // Checking if the bike at bikeIndex has already been assigned
                if ((mask & (1 << bikeIndex)) == 0) {
                    int newMask = (1 << bikeIndex) | mask;
                    
                    // Updating the distance sum for newMask
                    memo[newMask] = Math.min(memo[newMask], memo[mask] + 
                                             findDistance(workers[nextWorkerIndex], bikes[bikeIndex]));
                }
            }
        }
        
        return smallestDistanceSum;
    }
    
    public int assignBikes(int[][] workers, int[][] bikes) {      
        // Initializing the answers for all masks to be INT_MAX
        Arrays.fill(memo, Integer.MAX_VALUE);
        return minimumDistanceSum(workers, bikes);
	}
}