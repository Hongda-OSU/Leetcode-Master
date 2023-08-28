class Solution {
    public int[][] highFive(int[][] items) {
        Arrays.sort(items, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        List<int[]> list = new ArrayList<>();
        int count = 0, sum = 0, prevId = -1;
        for (int[] item : items) {
            if (item[0] != prevId) {
                count = 1;
                prevId = item[0];
                sum = item[1];
            } else {
                count++;
                sum += item[1];
            }
            if (count == 5) 
                list.add(new int[]{item[0], sum / 5});
        }
        int[][] result = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            result[i][0] = list.get(i)[0];
            result[i][1] = list.get(i)[1];
        }
        return result;
    }
}