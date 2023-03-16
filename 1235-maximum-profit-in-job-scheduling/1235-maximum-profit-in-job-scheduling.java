class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        Job[] jobs = new Job[n];
        for (int i = 0; i < n; i++)
            jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
        return schedule(jobs);
    }
    
    public int schedule(Job[] jobs) {
        Arrays.sort(jobs, Comparator.comparingInt(a -> a.finish));
        int n = jobs.length;
        int[] dp = new int[n];
        dp[0] = jobs[0].profit;
        for (int i = 1; i < n; i++) {
            int profit = jobs[i].profit;
            int k = search(jobs, i);
            if (k != -1)
                profit += dp[k];
            dp[i] = Math.max(profit, dp[i - 1]);
        }
        return dp[n - 1];
    }
    
    public int search(Job[] jobs, int idx) {
        int start = 0, end = idx - 1;
        while (start <= end) {
            int pivot = (start + end) >>> 1;
            if (jobs[pivot].finish <= jobs[idx].start) {
                if (jobs[pivot + 1].finish <= jobs[idx].start)
                    start = pivot + 1;
                else
                    return pivot;
            } else {
                end = pivot - 1;
            }
        }
        return -1;
    }
}

class Job {
    public int start, finish, profit;
    
    public Job(int start, int finish, int profit) {
        this.start = start;
        this.finish = finish;
        this.profit = profit;
    }
}