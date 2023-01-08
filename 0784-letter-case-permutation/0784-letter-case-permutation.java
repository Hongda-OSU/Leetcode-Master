class Solution {
     public List<String> letterCasePermutation(String s) {
        List<String> ans = new ArrayList<>();
        backtrack(ans, 0, s.toCharArray());
        return ans;
    }
    public void backtrack(List<String> ans, int index, char[] s){
        if(index == s.length)
            ans.add(new String(s));
        else{
            if(Character.isLetter(s[index])){ //If it's letter
                s[index] = Character.toUpperCase(s[index]);
                backtrack(ans, index + 1, s); //Upper case branch
                s[index] = Character.toLowerCase(s[index]);
                backtrack(ans, index + 1, s); //Lower case branch
            }
            else
                backtrack(ans, index + 1, s); 
        }
    }
}