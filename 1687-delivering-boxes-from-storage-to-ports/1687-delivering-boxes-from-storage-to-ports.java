class Solution {
    public int boxDelivering(int[][] boxes, int portsCount, int maxBoxes, int maxWeight) {
        int n = boxes.length;
        int[] trips = new int[n + 1];
        int start = 0, diff = 0;
        for (int i = 0; i < n; i++) {
            maxWeight -= boxes[i][1];
            maxBoxes--;
            if (i > 0 && boxes[i][0] != boxes[i - 1][0])
                diff++;
            while (maxWeight < 0 || maxBoxes < 0 || (start < i && trips[start + 1] == trips[start])) {
                maxWeight += boxes[start++][1];
                maxBoxes++;
                if (boxes[start][0] != boxes[start - 1][0])
                    diff--;
            }
            trips[i + 1] = trips[start] + diff + 2;
        }
        return trips[n];
    }
}