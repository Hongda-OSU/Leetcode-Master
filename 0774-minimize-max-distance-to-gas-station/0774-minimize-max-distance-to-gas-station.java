class Solution {
    public double minmaxGasDist(int[] stations, int k) {
        int count = 0, n = stations.length;
        double left = 0, right = stations[n - 1] - stations[0];
        while (left + 1e-6 < right) {
            double pivot = left + (right - left) / 2.0;
            count = 0;
            for (int i = 0; i < n - 1; i++) 
                count += Math.ceil((stations[i + 1] - stations[i]) / pivot) - 1;
            if (count > k)
                left = pivot;
            else 
                right = pivot;
        }
        return right;
    }
}