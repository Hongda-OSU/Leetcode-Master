class Solution {
    public int findBestValue(int[] arr, int target) {
        int max = 0, sum = 0;
        for (int num : arr) {
            max = Math.max(max, num);
            sum += num;
        }
        if (sum <= target) 
            return max;
        int left = 0, right = sum, leftSum = getSum(arr, left), rightSum = getSum(arr, right);
        while (Math.abs(left - right) != 1) {
            int pivot = (left + right) >>> 1;
            int pivotSum = getSum(arr, pivot);
            if (pivotSum < target) {
                left = pivot;
                leftSum = pivotSum;
            } else if (pivotSum > target) {
                right = pivot;
                rightSum = pivotSum;
            } else {
                return pivot;
            }
        }
        if (Math.abs(leftSum - target) <= Math.abs(rightSum - target))
            return left;
        else 
            return right;
    } 
    
    public int getSum(int[] arr, int idx) {
        int sum = 0;
        for (int num : arr)
            sum += Math.min(num, idx);
        return sum;
    }
}