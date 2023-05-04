class Solution {
  public int getMaximumConsecutive(int[] c) {
    Arrays.sort(c);
    int max_val = 1;
    for (int i = 0; i < c.length && c[i] <= max_val; ++i)
        max_val += c[i];
    return max_val;        
}
}