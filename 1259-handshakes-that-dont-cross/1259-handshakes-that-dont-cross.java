class Solution {
    public int numberOfWays(int numPeople) {
        long[] arr = new long[numPeople / 2 + 2];
        arr[1] = 1;
        long mod = (long)1e9 + 7, result = 1;
        for (int i = 2; i < numPeople / 2 + 2; i++) 
            arr[i] = mod - mod / i * arr[(int)mod % i] % mod;
        for (int i = 1; i <= numPeople / 2; i++) {
            result = result * (i + numPeople / 2) % mod;
            result = result * arr[i] % mod;
        }
        return (int)(result * arr[numPeople / 2 + 1] % mod);
    }
}