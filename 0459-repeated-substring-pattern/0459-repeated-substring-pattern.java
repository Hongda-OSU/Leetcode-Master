class Solution {
    public boolean repeatedSubstringPattern(String s) {

        if(s.length()==1) return false;
        if(s.length()==2) return s.substring(0,1).equals(s.substring(1));

        int size = s.length();
        for(int i=2;i<=size/2;i++){
            if(size%i==0){
                String str = s.substring(0,size/i);
                int count = 0;

                for(int j=size/i;j<size;j+=size/i){
                    if(s.substring(j,j+size/i).equals(str)){
                        count++;
                    }else{
                        count=0;
                        break;
                    }
                }

                if(count==i-1) return true;
            }
        }

        int a = s.charAt(0);
        for(char ch : s.toCharArray()){
            if(a!=ch) return false;
        }
        return true;
    }
}