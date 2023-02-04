class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int distance = 0;
        for (int num : arr1) {
            if (notInRange(arr2, num - d, num + d))
                distance++;
        }
        return distance;
    }
    
    public boolean notInRange(int[] arr, int from, int to) {
        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int pivot = (start + end) >>> 1;
            if (arr[pivot] >= from && arr[pivot] <= to) 
                return false;
            else if (arr[pivot] < from) 
                start = pivot + 1;
            else 
                end = pivot - 1;
        }
        return true;
    }
}