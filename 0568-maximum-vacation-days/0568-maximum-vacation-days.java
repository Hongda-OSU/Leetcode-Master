class Solution {
    public int maxVacationDays(int[][] flights, int[][] days) {
        int[] memo=new int[days.length];
        Arrays.fill(memo,-1);
        memo[0]=0;
        for(int i=0;i<days[0].length;i++) {
            int[] tmp=new int[days.length];
            Arrays.fill(tmp,-1);
            for(int j=0;j<memo.length;j++) {
                int m=memo[j];
                for(int k=0;k<memo.length&&m>=0;k++) {
                    if((j==k||flights[j][k]==1)) {
                        tmp[k]=Math.max(tmp[k],m+days[k][i]);
                    }
                }
            }
            memo=tmp;
        }
        int max=0;
        for(int g: memo) max=Math.max(max,g);
        return max;
    }
}