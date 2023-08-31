class Solution {
    public String[] expand(String S) {
      List<String> res = new ArrayList<>();
      dfs(S, 0, new StringBuilder(), res);   
      
      String[] out = new String[res.size()];
      for (int i = 0; i < res.size(); i++) { out[i] = res.get(i); }
      return out;
  }
  
  private void dfs(String s, int index, StringBuilder sb, List<String> res) {
      if (index == s.length()) {
          if (sb.length() > 0) { res.add(sb.toString()); }
          return;
      }
      
      char c = s.charAt(index);
      int position = sb.length();
      if (c == '{') {
          List<Character> charList = new ArrayList<>();
          int endIndex = index + 1;
          while (endIndex < s.length() && s.charAt(endIndex) != '}') { 
              if (Character.isLetter(s.charAt(endIndex))) { charList.add(s.charAt(endIndex)); }
              endIndex++; 
          }    
          
          Collections.sort(charList);
          for (char d : charList) {
              sb.append(d);
              dfs(s, endIndex + 1, sb, res);
              sb.setLength(position);
          }
          
      } else if (Character.isLetter(c)) {
          sb.append(s.charAt(index));
          dfs(s, index + 1, sb, res);    
      }
  }
}