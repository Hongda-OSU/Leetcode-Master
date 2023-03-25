class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < pid.size(); i++) {
            map.putIfAbsent(ppid.get(i), new ArrayList<>());
            map.get(ppid.get(i)).add(pid.get(i));
        }
        List<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(kill);
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            result.add(curr);
            if (map.containsKey(curr))
                queue.addAll(map.get(curr));
        }
        return result;
    }
}