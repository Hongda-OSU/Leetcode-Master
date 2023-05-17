class Solution {
    public String simplifyPath(String path) {
        int len=path.length();
        char []stack=new char[len];
        int i=0;
		    int j=-1;
        while(i<len){
            if(j>=0 && (stack[j] == '/' || i==len-1) && path.charAt(i)=='/') {
                i++;
                continue;
            }
            if(path.charAt(i)=='.' && stack[j] == '/' ){
                int dot=0;
                while(i<len && path.charAt(i)!='/'){
                    dot++;
                    if(path.charAt(i)!='.'){
                        dot+=5;
                        break;
                    }
                    stack[++j]=path.charAt(i);
                    i++;
                }
                if(dot<3){
                     while(j>=0 && dot>0){
                    if(stack[j--]=='/')dot--;
                    }
                    if(j==-1) j=0;
                }
            }
            else{
                    stack[++j]=path.charAt(i);
                    i++;
                } 
        }
        if(stack[j]=='/'&& j>1) j--;

        return String.valueOf(stack,0,j+1);
  }
}