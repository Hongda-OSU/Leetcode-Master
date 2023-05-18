class Solution {
    public boolean canWin(String currentState) {
        char[] charArray = currentState.toCharArray();
        return canWinHelper(charArray ,new HashMap<String, Boolean>());
    }
    private boolean canWinHelper(char[] charArray, HashMap<String, Boolean> map) {
        
        String currentState = new String(charArray);
        if(map.containsKey(currentState)) return map.get(currentState);
        
        for(int i=0;i<charArray.length-1;i++) {
            // chance that the current player could make
            if(charArray[i] == '+' && charArray[i+1] == '+') {
                charArray[i] = '-';
                charArray[i+1] = '-';
                String opponent = new String(charArray);
                if(!canWinHelper(opponent.toCharArray(), map)) {
                    map.put(currentState , true);
                    return true;
                }
                charArray[i] = '+';
                charArray[i+1] = '+';
            }
        }
        map.put(currentState, false);
        return false;
    }
}