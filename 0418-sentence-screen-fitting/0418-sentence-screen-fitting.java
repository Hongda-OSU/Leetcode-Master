class Solution {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        int n = sentence.length, total = 0;
        int[] arr = new int[n];
        for(int i=0; i<n; ++i) {
            arr[i] = sentence[i].length(); // Collect word lengths
            if(arr[i] > cols) // Early terminate if any word larger than cols
                return 0;
            total += arr[i]; // Note sum of lengths
        }
        
        total += n; // Size of a loop including spaces
        int loopsPerRow = cols/total; // This much is guaranteed per row
        int slotsAfterLoops = cols%total;
        
        /* store[i]: Pair {count, end} corresponding to a row starting with i'th word
            count: Number of times we complete the sentence in this row
            end: Starting word for the NEXT row */
        int[][] store = new int[n][];
        for(int i=0; i<n; ++i) {
            int count = loopsPerRow, slots = slotsAfterLoops, end = i;
            while(slots >= nextWordCost(arr, end, end != i)) {
                slots -= nextWordCost(arr, end, end != i);
                if(end == n-1)
                    ++count;
                end = inc(end, n);
            }
            store[i] = new int[] {count, end};
        }
        
        // Compute the answer - evaluating row by row
        int ans = 0, index = 0;
        while(rows > 0) {
            ans += store[index][0];
            index = store[index][1];
            --rows;
        }
        return ans;
    }
    
    private int nextWordCost(int[] arr, int index, boolean spaceNeeded) {
        return (spaceNeeded ? 1 : 0) + arr[index];
    }
    
    private int inc(int i, int n) {
        return (++i >= n) ? (i - n) : i;
    }
}