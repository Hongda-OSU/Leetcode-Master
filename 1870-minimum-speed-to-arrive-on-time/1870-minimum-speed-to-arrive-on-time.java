class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        int left = 1, right = Integer.MAX_VALUE;
        while (left < right) {
            int pivot = (left + right) >>> 1;
            if (arriveOnTime(dist, hour, pivot))
                right = pivot;
            else 
                left = pivot + 1;
        }
        return right == Integer.MAX_VALUE ? -1 : right;
    }
    
    public boolean arriveOnTime(int[] dist, double hour, int speed) {
        int time = 0;
        for (int i = 0; i < dist.length - 1; i++) {
            time += Math.ceil((double) dist[i] / speed);
        }
        return time + (double) dist[dist.length - 1] / speed <= hour;
    }
}