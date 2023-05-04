class Solution {
    public int getMaximumConsecutive(int[] c) {
         Arrays.sort(c);
        int n = c.length;
        int sum = 1;
        for(int i=0;i<n;i++){
            if(c[i]<=sum) sum=sum+c[i];
            else break;
        }
        return sum;
    }
}