class Solution {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        int n = sentence.length, total = 0;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sentence[i].length();
            if (arr[i] > cols) 
                return 0;
            total += arr[i];
        }
        total += n;
        int loopsPerRow = cols / total;
        int slotsAfterLoops = cols % total;
        int[][] store = new int[n][];
        for (int i = 0; i < n; i++) {
            int count = loopsPerRow, slots = slotsAfterLoops, end = i;
            while (slots >= nextWordCost(arr, end, end != i)) {
                slots -= nextWordCost(arr, end, end != i);
                if (end == n - 1) 
                    count += 1;
                end = increase(end, n);
            }
            store[i] = new int[]{count, end};
        } 
        int result = 0, index = 0;
        while (rows > 0) {
            result += store[index][0];
            index = store[index][1];
            rows -= 1;
        }
        return result;
    }
    
    private int nextWordCost(int[] arr, int index, boolean spaceNeeded) {
        return (spaceNeeded ? 1 : 0) + arr[index];
    }
    
    private int increase(int i, int n) {
        return (++i >= n) ? (i - n) : i;
    }
}