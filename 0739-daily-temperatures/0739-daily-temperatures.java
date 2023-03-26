class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int hottest = 0;
        int[] result = new int[n];
        for (int currDay = n - 1; currDay >= 0; currDay--) {
            int temperature = temperatures[currDay];
            if (temperature >= hottest) {
                hottest = temperature;
                continue;
            }
            int days = 1;
            while (temperatures[currDay + days] <= temperature) 
                days += result[currDay + days];
            result[currDay] = days;
        }
        return result;
    }
}