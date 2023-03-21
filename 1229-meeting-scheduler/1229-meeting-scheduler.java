class Solution {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        Arrays.sort(slots1, (a, b) -> a[0] - b[0]);
        Arrays.sort(slots2, (a, b) -> a[0] - b[0]);
        int p1 = 0, p2 = 0;
        while (p1 < slots1.length && p2 < slots2.length) {
            int leftIntersect = Math.max(slots1[p1][0], slots2[p2][0]);
            int rightIntersect = Math.min(slots1[p1][1], slots2[p2][1]);
            if (rightIntersect - leftIntersect >= duration)
                return new ArrayList<>(Arrays.asList(leftIntersect, leftIntersect + duration));
            if (slots1[p1][1] < slots2[p2][1])
                p1++;
            else 
                p2++;
        }
        return new ArrayList<>();
    }
}