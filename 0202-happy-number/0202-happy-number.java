class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1 && !set.contains(n)) {
            set.add(n);
            n = getNextN(n);
        }
        return n == 1;
    }
    
    public int getNextN(int n) {
        int result = 0;
        while (n > 0) {
            int temp = n % 10;
            result += temp * temp;
            n /= 10;
        }
        return result;
    }
}