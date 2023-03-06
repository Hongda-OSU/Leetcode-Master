class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = 0, right = 0, result = 0;
        for (int weight : weights) {
            left = Math.max(left, weight);
            right += weight;
        }
        while (left <= right) {
            int pivot = (left + right) >>> 1;
            if (check(weights, days, pivot)) {
                result = pivot;
                right = pivot - 1;
            } else {
                left = pivot + 1;
            }
        }
        return result;
    }
    
    public boolean check(int[] weights, int days, int capacity) {
        int requiredDays = 1, currWeight = 0;
        for (int weight : weights) {
            if (currWeight + weight > capacity) {
                requiredDays++;
                currWeight = 0;
            } 
            currWeight += weight;
        }
        if (requiredDays > days)
            return false;
        return true;
    }
}