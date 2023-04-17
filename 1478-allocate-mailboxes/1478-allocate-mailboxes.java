class Solution {
    private int[][] cache;

    public int minDistance(int[] houses, int k) {
        cache = new int[houses.length][k + 1];
        Arrays.sort(houses);
        return minDist(houses, 0, k);
    }

    private int minDist(int[] houses, int pos, int k) {
        if (cache[pos][k] != 0) {
            return cache[pos][k] - 1;
        }

        if (k == 1) {
            int n = houses.length - pos;

            if (n < 4) {
                cache[pos][k] = houses[pos + n - 1] - houses[pos] + 1;
            } else {
                int sum = 0;
                int m = houses[pos + n / 2];

                for (int p = pos; p < houses.length; p++) {
                    sum += Math.abs(houses[p] - m);
                }
                cache[pos][k] = sum + 1;
            }
        } else if (houses.length - pos == k) {
            cache[pos][k] = 1;
            return 0;
        } else {
            int sum = 0;
            int min = minDist(houses, pos + 1, k - 1);

            for (int i = pos + 1, is = (pos + (houses.length - k + 1)) >> 1; ; i++) {
                sum += houses[i + (i - pos - 1)] - houses[i - 1];
                min = Math.min(min, sum + minDist(houses, i + i - pos, k - 1));

                if (i == is) {
                    if (i + i - pos <= houses.length - k) {
                        sum += houses[i + i - pos] - houses[i];
                        min = Math.min(min, sum + minDist(houses, i + i - pos + 1, k - 1));
                    }
                    break;
                }
                sum += houses[i + i - pos] - houses[i];
                min = Math.min(min, sum + minDist(houses, i + i - pos + 1, k - 1));
            }
            cache[pos][k] = min + 1;
            return min;
        }

        return cache[pos][k] - 1;
    }
}