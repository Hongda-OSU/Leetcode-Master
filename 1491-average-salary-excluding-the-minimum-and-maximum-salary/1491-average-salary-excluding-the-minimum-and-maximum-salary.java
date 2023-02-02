class Solution {
    public double average(int[] salary) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        double sum = 0;
        for (int s : salary) {
            min = Math.min(s, min);
            max = Math.max(s, max);
            sum += s;
        }
        sum = sum - min - max;
        return sum / (salary.length - 2);
    }
}