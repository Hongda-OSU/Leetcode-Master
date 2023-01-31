class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int i = 0;
        for (; left != right; i++) {
            left >>= 1;
            right >>= 1;
        }
        return right << i;
    }
}