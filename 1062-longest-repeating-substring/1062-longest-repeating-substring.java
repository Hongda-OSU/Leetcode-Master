class Solution {
    private static int a = 26;
    private static long modulus = (long)Math.pow(2, 24);
    
    public int longestRepeatingSubstring(String s) {
        int n = s.length();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++)
            nums[i] = s.charAt(i) - 'a';
        int left = 1, right = n;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (search(mid, n, nums) != -1)
                left = mid + 1;
            else 
                right = mid - 1;
        }
        return left - 1;
    }
    
    private int search(int l, int n, int[] nums) {
        long hash = 0;
        for (int i = 0; i < l; i++)
            hash = (hash * a + nums[i]) % modulus;
        HashSet<Long> visited = new HashSet<>();
        visited.add(hash);
        long aL = 1;
        for (int i = 1; i <= l; i++)
            aL = (aL * a) % modulus;
        for (int i = 1; i < n - l + 1; i++) {
            hash = (hash * a - nums[i - 1] * aL % modulus + modulus) % modulus;
            hash = (hash + nums[i + l - 1]) % modulus;
            if (visited.contains(hash))
                return i;
            visited.add(hash);
        }
        return -1;
    }
}