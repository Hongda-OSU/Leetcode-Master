class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        
        // the final justified list of lines to return.
        List<String> justified = new ArrayList();
       
        // a queue to store all the words of a current line.
        Queue<String> currentLine = new LinkedList();
        
        // efficiently build a new line with a string builder.
        StringBuilder sb = new StringBuilder();
        
        // keep track of all the lengths of each word on the current line (to compare to maxWidth).
        int currentLineLen = 0;
        
        for(String word : words){
            
            // track both the current words length and the count of all the words in the current line 
            // (this count represents the single space between each word so far)
            int n = word.length();
            int m = currentLine.size();
            
            // if all the words so far in the line, plus a single space between each of them, plus the current word length is 
            // less than or equal to the max width of a line, then add the current word to the current line.
            if(currentLineLen + n + m <= maxWidth){
                currentLine.add(word);
                currentLineLen += n;
            
            // otherwise, render the current line with the correct spacing between each word and start a new line with the current word.
            }else{
                int extraSpace = maxWidth - currentLineLen;
                justified.add(getLine(extraSpace, currentLine, sb));
                
                currentLine.add(word);
                sb.setLength(0);
                currentLineLen = n;
            }
        }
        
        // if after looping through each word, there are still words left in the current line
        // then add them to the justified list of lines through a special final string.
        if(!currentLine.isEmpty()){
            int remainingSpace = maxWidth - (currentLineLen + currentLine.size() - 1);
            justified.add(generateLastLine(remainingSpace, currentLine, sb));
        }
        
        return justified;
    }
    
    /**
     * This method renders a standard line (not the final line) by taking the total amount of space
     * left in the line an distributing the space as equally as possible between the words of the, but 
     * giving words on the left more space between them than words on the right if the remaining free space
     * cant be split equally between all the words.
    **/
    private String getLine(int extraSpace, Queue<String> currentLine, StringBuilder sb){
        
        int wordCount = currentLine.size() - 1;
        
        boolean singleWordLine = wordCount == 0;
        
        while(!currentLine.isEmpty()){
            sb.append(currentLine.poll());

            if(!currentLine.isEmpty() || singleWordLine){
                
                int currentSpace = !singleWordLine ? extraSpace / wordCount : extraSpace;
                
                if(!singleWordLine && extraSpace % wordCount != 0)
                    currentSpace++;
                
                addEmptySpace(currentSpace, sb);
                
                extraSpace -= currentSpace;
                wordCount--;
            }
        }
        
        return sb.toString();
    }
    
    /**
     * This method renders the final line by placing a single space in between each word and then adding
     * any remaing empty space to the end of the line.
    **/ 
    private String generateLastLine(int remainingSpace, Queue<String> currentLine, StringBuilder sb){
         
        while(!currentLine.isEmpty()){
            sb.append(currentLine.poll());
            
            if(!currentLine.isEmpty())
                sb.append(" ");
        }
        
        if(remainingSpace > 0)
            addEmptySpace(remainingSpace, sb);
        
        return sb.toString();
    }
    
    /**
     * This method will add the number of empty spaces to the current string builder to match a given length.
    **/
    private void addEmptySpace(int len, StringBuilder sb){
        for(int i = 0; i < len; i++)
            sb.append(" ");
    }
}