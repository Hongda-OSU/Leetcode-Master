class Solution {
    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        int n = locations.length;
        int[][] memo = new int[n][fuel + 1];
        for (int i = 0; i < n; i++)
            Arrays.fill(memo[i], -1);
        return helper(locations, start, finish, fuel, memo);
    }
    
    private int helper(int[] locations, int currCity, int finish, int fuelRemain, int[][] memo) {
        if (fuelRemain < 0)
            return 0;
        if (memo[currCity][fuelRemain] != -1)
            return memo[currCity][fuelRemain];
        int result = currCity == finish ? 1 : 0;
        for (int nextCity = 0; nextCity < locations.length; nextCity++) {
            if (nextCity != currCity) {
                result = (result + helper(locations, nextCity, finish, fuelRemain - Math.abs(locations[currCity] - locations[nextCity]), memo)) % 1_000_000_007;
            }
        }
        return memo[currCity][fuelRemain] = result;
    }
}