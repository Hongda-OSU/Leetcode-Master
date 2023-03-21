class Solution {
    public double minmaxGasDist(int[] stations, int k) {
        double low = 0, high = 1e8;
        while (high - low > 1e-6) {
            double pivot = low + (high - low) / 2.0;
            if (possible(pivot, stations, k))
                high = pivot;
            else
                low = pivot;
        }
        return low;
    }

    public boolean possible(double pivot, int[] stations, int k) {
        int count = 0;
        for (int i = 0; i < stations.length - 1; i++)
            count += (int)((stations[i + 1] - stations[i]) / pivot);
        return count <= k;
    }
}