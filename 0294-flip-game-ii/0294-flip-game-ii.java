class Solution {
    public boolean canWin(String currentState) {
        return canWin(currentState, new HashMap<String,Boolean>());
    }
  
    private boolean canWin(String currentState, Map<String,Boolean> state){
      currentState = trimDashes(currentState);
      if(state.containsKey(currentState))
        return state.get(currentState);
      else if(currentState.indexOf("++") == -1){
        state.put(currentState,false);
        return false;
      }
      
      char[] candidates = currentState.toCharArray();
      for (int i = 1; i < candidates.length; i++)
        if(candidates[i] == '+' && candidates[i-1] == '+' && testCandidate(candidates,state,i))
          return true;
      
      state.put(currentState,false);
      return false;
    }
  
    private boolean testCandidate(char[] candidates, Map<String,Boolean> state, int i){
          candidates[i] = '-';
          candidates[i-1] = '-';
          String currentState = String.valueOf(candidates);
          candidates[i] = '+';
          candidates[i-1] = '+';
          
          boolean win = canWin(currentState,state);
          state.put(currentState, win);
      
          // This is notted, because the above calculation is after the
          // current player moves, so if the other player wins, the current player loses
          return !win;
    }
    
	// This method is not needed, but cuts down performance from 12ms to 5ms. The presence
	// of a '-' on either terminal does not affect outcome, so it is more efficient to cut them
	// out so as to minimize the input size for more complicated operations later on
    private String trimDashes(String currentState){
      int begin = 0;
      while(begin < currentState.length() && currentState.charAt(begin) == '-')
        begin++;
      
      int end = currentState.length()-1;
      while(end >= 0 && currentState.charAt(end) == '-')
        end--;
      
      if(begin < end)
        return currentState.substring(begin,end+1);
      else
        return "";
    }
}