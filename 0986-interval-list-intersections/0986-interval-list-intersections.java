class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        ArrayList<int[]> list = new ArrayList<>();
        int l1 = firstList.length, l2 = secondList.length;
        if (l1 == 0 || l2 == 0) return new int[0][0];
        int left = 0, right = 0, i = 0, j = 0;
        while (i < l1 && j < l2) {
            left = Math.max(firstList[i][0], secondList[j][0]);
            right = Math.min(firstList[i][1], secondList[j][1]);
            if (left <= right) list.add(new int[]{left, right});
            if (firstList[i][1] == right) i++;
            if (secondList[j][1] == right) j++;
        }
        return list.toArray(new int[list.size()][2]);
    }
}