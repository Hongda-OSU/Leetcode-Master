class Solution {
    public String addBoldTag(String s, String[] words) {
        int n = s.length();
        boolean[] bold = new boolean[n];
        for (String word : words) {
            int start = s.indexOf(word);
            while (start != -1) {
                for (int i = start; i < start + word.length(); i++) {
                    bold[i] = true;
                }
                start = s.indexOf(word, start + 1);
            }
        }
        
        String openTag = "<b>", closeTag = "</b>";
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < n; i++) {
            if (bold[i] && (i == 0 || !bold[i - 1]))
                sb.append(openTag);
            sb.append(s.charAt(i));
            if (bold[i] && (i == n - 1 || !bold[i + 1])) 
                sb.append(closeTag);
        }
        return sb.toString();
    }
}