class Solution {
    private int maxWidth;
    private String[] words;
    
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> text = new LinkedList<>();
        this.maxWidth = maxWidth;
        this.words = words;
        int start = 0, end = 1, lineLength = words[start].length();
        for (; end < words.length; end++) {
            String word = words[end];
            if (lineLength + word.length() + 1 <= maxWidth)
                lineLength += word.length() + 1;
            else {
                text.add(constructLine(start, end, lineLength));
                start = end;
                lineLength = word.length();
            }
        }
        if (end - start > 0)
            text.add(lineWithoutInterWordPadding(start, end, lineLength));
        return text;
    }
    
    private String constructLine(int start, int end, int lineLength) {
        int numSpaces = end - (start + 1);
        if (numSpaces == 0)
            return lineWithoutInterWordPadding(start, end, lineLength);
        int padding = maxWidth - lineLength;
        int spaceNeeded = padding / numSpaces + 1;
        int leftOverSpaces = padding % numSpaces;
        StringBuilder sb = new StringBuilder();
        sb.append(words[start]);
        for (int i = start + 1; i < end; i++) {
            sb.append(" ".repeat(spaceNeeded));
            if (leftOverSpaces-- > 0)
                sb.append(" ");
            sb.append(words[i]);
        }
        return sb.toString();
    }
    
    private String lineWithoutInterWordPadding(int start, int end, int lineLength) {
        StringBuilder sb = new StringBuilder();
        sb.append(words[start]);
        for (int i = start + 1; i < end; i++) {
            sb.append(" ");
            sb.append(words[i]);
        } 
        return sb.toString() + " ".repeat(maxWidth - lineLength);
    }
}