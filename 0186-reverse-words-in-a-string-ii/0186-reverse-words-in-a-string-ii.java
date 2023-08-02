class Solution {
    public void reverseWords(char[] s) {
        reverse(s,0,s.length-1);
        int end=0,i=0;
        while(i<s.length)
        {
            while(end<s.length&&s[end]!=' ')
            {
                end++;
            }
            reverse(s,i,end-1);
            end++;
            i=end;
        }
    }
    public void reverse(char[] s,int i,int j)
    {
        while(i<=j)
        {
           char temp=s[i];
           s[i]=s[j];
           s[j]=temp;
           i++;
           j--;
        }
    }
}