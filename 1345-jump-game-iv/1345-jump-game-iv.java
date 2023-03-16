class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;
        if (n == 1)
            return 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        int step = 0;
        for (int i = 0; i < n; i++)
            map.computeIfAbsent(arr[i], x -> new ArrayList<>()).add(i);
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int curr = queue.poll();
                if (curr - 1 >= 0 && map.containsKey(arr[curr - 1])) 
                    queue.offer(curr - 1);
                if (curr + 1 < n && map.containsKey(arr[curr + 1])) {
                    if (curr + 1 == n - 1)
                        return step;
                    queue.offer(curr + 1);
                }
                if (map.containsKey(arr[curr])) {
                    for (int k : map.get(arr[curr])) {
                        if (k != curr) {
                            if (k == n - 1)
                                return step;
                            queue.offer(k);
                        }
                    }
                }
                map.remove(arr[curr]);
            }
        }
        return step;
    }
}