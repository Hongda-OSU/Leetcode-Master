class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        long sum = 0;
        for (int c : chalk) 
            sum += c;
        // after all cycles she is left with how many chalks 
        long reminder = k % sum;
        for (int i = 0; i < chalk.length; i++) {
            if (reminder - chalk[i] >= 0)
                reminder -= chalk[i];
            else 
                return i;
        }
        return -1;
    }
}