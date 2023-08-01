class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int result = 0;
        List<Integer> list = arrays.get(0);
        // Each array is sorted in ascending order !
        int min = list.get(0), max = list.get(list.size() - 1);
        for (int i = 1; i < arrays.size(); i++) {
            List<Integer> curr = arrays.get(i);
            int tempMin = curr.get(0), tempMax = curr.get(curr.size() - 1);
            result = Math.max(result, Math.max(tempMax - min, max - tempMin));
            min = Math.min(min, tempMin);
            max = Math.max(max, tempMax);
        }
        return result;
    }
}