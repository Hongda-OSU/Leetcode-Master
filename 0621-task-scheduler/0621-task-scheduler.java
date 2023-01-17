class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] counter = new int[26];
        // max: how many "the most appearing chars"
        // maxCount: how many different "the most appearing chars"
        int max = 0, maxCount = 0;
        for (char task : tasks) {
            counter[task - 'A']++;
            if (counter[task - 'A'] == max) {
                maxCount++;
            } else if (counter[task - 'A'] > max) {
                max = counter[task - 'A'];
                maxCount = 1;
            }
        }
        // intervals is the interval between "the most appearing chars"
        // ex:"AXXAXXA" -> intervals = 2, intervalLength = 2
        int intervals = max - 1;
        int intervalLength = n - (maxCount - 1);
        int emptySlots = intervals * intervalLength;
        int availableTasks = tasks.length - max * maxCount;
        int idle = Math.max(0, emptySlots - availableTasks);
        return tasks.length + idle;
    }
}