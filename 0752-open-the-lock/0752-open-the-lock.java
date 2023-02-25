class Solution {
    public int openLock(String[] deadends, String target) {
        if (target.equals("0000"))
            return 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        boolean[] seen = new boolean[10000];
        for (String str : deadends)
            seen[Integer.parseInt(str)] = true;
        int t = Integer.parseInt(target);
        if (seen[0])
            return -1;
        for (int i = 1; !queue.isEmpty(); i++) {
            int n = queue.size();
            for (int j = 0; j < n; j++) {
                int curr = queue.poll();
                for (int k = 1; k < 10000; k *= 10) {
                    int mask = curr % (k * 10) / k, masked = curr - (mask * k);
                    for (int z = 1; z < 10; z += 8) {
                        int next = masked + (mask + z) % 10 * k;
                        if (seen[next])
                            continue;
                        if (next == t)
                            return i;
                        seen[next] = true;
                        queue.add(next);
                    }
                }
            }
        }
        return -1;
    }
}