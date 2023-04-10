class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        int[] count = new int[k];
        PriorityQueue<Integer> free = new PriorityQueue<>((a, b) -> a - b);
        PriorityQueue<Pair<Integer, Integer>> busy = new PriorityQueue<>((a, b) -> a.getKey() - b.getKey());
        
        // All servers are free at the beginning.

        for (int i = 0; i < k; ++i) {
            free.add(i);
        }
        
        for (int i = 0; i < arrival.length; ++i) {
            int start = arrival[i];

            // Remove free servers from 'busy', modify their IDs and
            // add them to 'free'
            while (!busy.isEmpty() && busy.peek().getKey() <= start) {
                Pair<Integer, Integer> curr = busy.remove();
                int serverId = curr.getValue();
                int modifiedId = ((serverId - i) % k + k) % k + i;
                free.add(modifiedId);
            }

            // Get the original server ID by taking the remainder of
            // the modified ID to k.
            if (!free.isEmpty()) {
                int busyId = free.peek() % k;
                free.remove();
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