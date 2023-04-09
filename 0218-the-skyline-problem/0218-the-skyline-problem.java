class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
		List<List<Integer>> res = new ArrayList<>();
		if (buildings.length == 0) return res;
		int n = buildings.length;
		return findSkyline(buildings, 0, n - 1);
	}

	private List<List<Integer>> findSkyline(int[][] buildings, int lo, int hi) {
		List<List<Integer>> res = new LinkedList<>();
		if (lo == hi) {
			res.add(Arrays.asList(buildings[lo][0], buildings[lo][2]));
			res.add(Arrays.asList(buildings[lo][1], 0));
			return res;
		}
		int mid = lo + (hi - lo) / 2;
		List<List<Integer>> skyline1 = findSkyline(buildings, lo, mid);
		List<List<Integer>> skyline2 = findSkyline(buildings, mid + 1, hi);
		return mergeSkyline(skyline1, skyline2);
	}

	private List<List<Integer>> mergeSkyline(List<List<Integer>> skyline1, List<List<Integer>> skyline2) {
		List<List<Integer>> res = new LinkedList<>();
		int i = 0, j = 0;
		int h1 = 0, h2 = 0;

		while (i < skyline1.size() && j < skyline2.size()) {
			int x1 = skyline1.get(i).get(0);
			int x2 = skyline2.get(j).get(0);
			int x;
			if (x1 < x2) {
				h1 = skyline1.get(i++).get(1);
				x = x1;
			} else if (x1 > x2) {
				h2 = skyline2.get(j++).get(1);
				x = x2;
			} else {
				h1 = skyline1.get(i++).get(1);
				h2 = skyline2.get(j++).get(1);
				x = x1;
			}
			int h = Math.max(h1, h2);

			if (res.isEmpty() || h != res.get(res.size() - 1).get(1)) {
				res.add(Arrays.asList(x, h));
			}
		}

		while (i < skyline1.size()) res.add(skyline1.get(i++));
		while (j < skyline2.size()) res.add(skyline2.get(j++));

		return res;
	}
}