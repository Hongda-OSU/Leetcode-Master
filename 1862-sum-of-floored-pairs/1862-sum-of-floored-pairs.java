class Solution {
    public int MAX = (int)1e5;
    public int MODULUS = (int)1e9 + 7;
    
    public int sumOfFlooredPairs(int[] nums) {
        int[] counts = new int[MAX + 1];
        for (int num : nums)
            counts[num] += 1;
        for (int i = 1; i <= MAX; i++) 
            counts[i] += counts[i - 1];
        long total = 0;
        for (int i = 1; i <= MAX; i++) {
            if (counts[i] > counts[i - 1]) {
                long sum = 0;
                for (int j = 1; i * j <= MAX; j++) {
                    int lower = i * j - 1;
                    int upper = i * (j + 1) -1;
                    sum += (counts[Math.min(MAX, upper)] - counts[lower]) * (long)j;
                }
                total = (total + (sum % MODULUS) * (counts[i] - counts[i - 1])) % MODULUS;
            }
        }
        return (int)total;
    }
}