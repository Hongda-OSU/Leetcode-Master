class Solution {
    public List<Integer> shortestDistanceColor(int[] colors, int[][] queries) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < colors.length; i++) {
            int c = colors[i];
            map.putIfAbsent(c, new ArrayList<>());
            map.get(c).add(i);
        }
        List<Integer> result = new ArrayList<>();
        for (int[] query : queries) {
            int idx = query[0];
            int c = query[1];
            if (!map.containsKey(c))
                result.add(-1);
            else 
                result.add(binarySearch(idx, map.get(c)));
        }
        return result;
    }
    
    public int binarySearch(int idx, List<Integer> list) {
        int left = 0, right = list.size() - 1;
        while (right - left > 1) {
            int pivot = (left + right) >>> 1;
            if (list.get(pivot) < idx) 
                left = pivot;
            else 
                right = pivot;
        }
        int leftDis = Math.abs(list.get(left) - idx);
        int rightDis = Math.abs(list.get(right) - idx);
        return leftDis <= rightDis ? leftDis : rightDis;
    }
}