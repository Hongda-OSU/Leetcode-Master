class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int result = 0;
        int MIN = 10001, MAX = -10001;
        for (int i = 0; i < arrays.size(); i++) {
            List<Integer> curr = arrays.get(i);
            int min = curr.get(0), max = curr.get(curr.size() - 1);
            result = Math.max(result, Math.max(max - MIN, MAX - min));
            MIN = Math.min(MIN, min);
            MAX = Math.max(MAX, max);
        }
        return result;
    }
}