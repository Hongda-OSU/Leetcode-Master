class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        int n = buildings.length;
        if (n == 0)
            return new ArrayList<>();
        return findSkyline(buildings, 0, n - 1);
    }
    
    public List<List<Integer>> findSkyline(int[][] buildings, int low, int high) {
        List<List<Integer>> result = new ArrayList<>();
        if (low == high) {
            result.add(Arrays.asList(buildings[low][0], buildings[low][2]));
            result.add(Arrays.asList(buildings[low][1], 0));
            return result;
        }
        int mid = low + (high - low) / 2;
        List<List<Integer>> skyline1 = findSkyline(buildings, low, mid);
        List<List<Integer>> skyline2 = findSkyline(buildings, mid + 1, high);
        return mergeSkyline(skyline1, skyline2);
    }
    
    public List<List<Integer>> mergeSkyline(List<List<Integer>> skyline1, List<List<Integer>> skyline2) {
        List<List<Integer>> result = new ArrayList<>();
        int i = 0, j = 0, high1 = 0, high2 = 0;
        while (i < skyline1.size() && j < skyline2.size()) {
            int x1 = skyline1.get(i).get(0), x2 = skyline2.get(j).get(0), x;
            if (x1 < x2) {
                high1 = skyline1.get(i++).get(1);
                x = x1;
            } else if (x1 > x2) {
                high2 = skyline2.get(j++).get(1);
                x = x2;
            } else {
                high1 = skyline1.get(i++).get(1);
                high2 = skyline2.get(j++).get(1);
                x = x1;
            }
            int high = Math.max(high1, high2);
            if (result.isEmpty() || high != result.get(result.size() - 1).get(1)) 
                result.add(Arrays.asList(x, high));
        }
        while (i < skyline1.size())
            result.add(skyline1.get(i++));
        while (j < skyline2.size())
            result.add(skyline2.get(j++));
        return result;
    }
}