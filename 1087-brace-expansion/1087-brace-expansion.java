class Solution {
    public String[] expand(String S) {
        
        List<String> result = new ArrayList<>();
        backtrack(S, 0, new StringBuilder(), result);
        
        String[] output = new String[result.size()];
        for(int i=0; i<output.length; i++) {
            output[i] = result.get(i);
        }
        
        Arrays.sort(output);
        return output;
   
    }
    
    public void backtrack(String s, int start, StringBuilder sb, List<String> result) {
        
        if(s.length() == start) {
            result.add(sb.toString());
            return;
        }
        
        if(Character.isLetter(s.charAt(start))) {
            
            sb.append(s.charAt(start));
            backtrack(s, start+1, sb, result);
            sb.deleteCharAt(sb.length()-1);
            
        } else if(s.charAt(start) == '{') {
            
            List<Character> list = new ArrayList<>();
            while(s.charAt(start) != '}') {
                start++;
                if(Character.isLetter(s.charAt(start))) {
                    list.add(s.charAt(start));
                }
            }
            
            for(Character c: list) {
                sb.append(c);
                backtrack(s, start+1, sb, result);
                sb.deleteCharAt(sb.length()-1);
            }
            
        }
    } 
    
}