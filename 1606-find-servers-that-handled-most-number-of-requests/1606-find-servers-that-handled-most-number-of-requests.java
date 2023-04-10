class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        int[] count = new int[k];
        TreeSet<Integer> free = new TreeSet<Integer>();
        PriorityQueue<Pair<Integer, Integer>> busy = new PriorityQueue<>((a, b) -> a.getKey() - b.getKey());
        
        // All servers are free at the beginning.

        for (int i = 0; i < k; ++i) {
            free.add(i);
        }
        
        for (int i = 0; i < arrival.length; ++i) {
            int start = arrival[i];

            // Move free servers from 'busy' to 'free'.
            while (!busy.isEmpty() && busy.peek().getKey() <= start) {
                Pair<Integer, Integer> curr = busy.remove();
                int serverId = curr.getValue();
                free.add(serverId);
            }

            // If we have free servers, use binary search to find the 
            // target server.
            if (!free.isEmpty()) {
                Integer busyId = free.ceiling(i % k);
                if (busyId == null) {
                    busyId = free.first();
                }
 
                free.remove(busyId);
                busy.add(new Pair<>(start + load[i], busyId));
                count[busyId]++;
            }
        }
        
        // Find the servers that have the maximum workload.
        int maxJob = Collections.max(Arrays.stream(count).boxed().collect(Collectors.toList()));
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < k; ++i) {
            if (count[i] == maxJob) {
                answer.add(i);
            }
        }
        
        return answer;
    }
}