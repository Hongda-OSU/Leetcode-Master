class Solution {
    public String shortestCommonSupersequence(String s1, String s2) {
        int n = s1.length(),m = s2.length();
        int[][] t = new int[n+1][m+1];
        for(int i= 0; i< n+1;i++){   //initialized
            for(int j = 0;j < m+1;j++){
                if(i == 0||j == 0) t[i][j] = 0;
            }
        }
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < m+1; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    t[i][j] = t[i-1][j-1]+1;
                }
                else{
                    t[i][j] = Math.max(t[i-1][j],t[i][j-1]);
                }
            }
        }
        StringBuilder sb =new StringBuilder();
        while(m > 0 && n >0){
            if(s1.charAt(n-1) == s2.charAt(m-1)){
                sb.append(s1.charAt(n-1));
                m--;
                n--;
            }
            else {
                if (t[n-1][m] >t[n][m-1]){
                    sb.append(s1.charAt(n-1));
                    n--;
                }
                else{
                    sb.append(s2.charAt(m-1));
                    m--;
                }
            }
        }
        while(n>0)
        {
            sb.append(s1.charAt(n-1));
            n--;
        }
        while(m>0)
        {
            sb.append(s2.charAt(m-1));
            m--;
        }
        return sb.reverse().toString();
    }
}