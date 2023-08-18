class Solution {
    public String parseTernary(String expression) {
        Deque<Character> s1 = new LinkedList<>();
        Deque<Character> s2 = new LinkedList<>();
        
        // Judge form right to left. So we add all char to s1.
        for(char exp : expression.toCharArray()) {
            // We don't need ":" due to one-digit number.
            if(exp != ':') {
                s1.push(exp);
            }
        }
        
        // If meet "?", we should check which digit needs to be kept.
        while(s1.size() + s2.size() > 1) {
            char nowC = s1.pop();
            
            if(nowC == '?') {
                char nextC = s1.pop();
                
                if(nextC == 'T') {
                    char temp = s2.pop();
                    s2.pop();
                    s2.push(temp);
                } else{
                    s2.pop();
                }
            } else {
                s2.push(nowC);
            }
        }
        
        return s2.pop().toString();
    }
}