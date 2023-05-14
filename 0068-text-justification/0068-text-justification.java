class Solution {
    private int maxWidth;
    private String[] words;
    
    public List<String> fullJustify(String[] ws, int maxW) {        
        
        List<String> text = new LinkedList<>();        
        maxWidth = maxW;
        words = ws; 
        // Use start/end indexes into words array to avoid making a list of words in current line (for efficiency).
        int start = 0; 
        int end = 1;
        int lineLen = words[start].length();
        
        for (; end < words.length; end++) {
            String word = words[end];
            
            if (lineLen + word.length() + 1 <= maxWidth) { // Word fits in this line. Plus one is for a space.
                lineLen += word.length() + 1; 
            } else { // Word does not fit in this line, space out current line and start a new one.
                text.add(constructLine(start, end, lineLen));
                start = end;
                lineLen = word.length();
            }   
        }
        
        if (end - start > 0) {
            text.add(lineWithoutInterWordPadding(start, end, lineLen));
        }
        
        return text;
    }
    
    private String lineWithoutInterWordPadding(int start, int end, int lineLength) {
        // Don't use stream Collectors.joining(" ") here, even though it is more readable. The below is faster.
        StringBuilder line = new StringBuilder();
        line.append(words[start]);
        for (int i = start + 1; i < end; i++) {
            line.append(" ");
            line.append(words[i]);
        }
        return line.toString() + " ".repeat(maxWidth - lineLength);
    }
    
    private String constructLine(int start, int end, int lineLength) {
        int numSpaces = end - (start + 1);
        
        if (numSpaces == 0) { // Only one word in the line.
            return lineWithoutInterWordPadding(start, end, lineLength);
        }
        
        int padding = maxWidth - lineLength;       // Extra padding needed.
        int spaceNeeded = padding / numSpaces + 1; // Padding between each word (extra + minimum one).
        int leftOverSpaces = padding % numSpaces;  // Extra spaces that don't divide evenly between words.
        
        StringBuilder line = new StringBuilder();
        line.append(words[start]);
        
        for (int i = start + 1; i < end; i++) {
            line.append(" ".repeat(spaceNeeded));
            if (leftOverSpaces-- > 0) {
                line.append(' ');
            }
            line.append(words[i]);
        }
        
        return line.toString();
    }
}