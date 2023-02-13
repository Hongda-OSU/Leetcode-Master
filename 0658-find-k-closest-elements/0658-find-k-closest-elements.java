class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        // The sliding window is between 'mid' and 'mid' + k.
        int left = 0, right = arr.length - k;
        while (left < right) {
            int pivot = (left + right) >>> 1;
            // With midpoint on the left, we use x - arr[midpoint], while arr[midpoint + k] - x because it is on the right.
            // Rather than using Math.abs(), we need the direction keep the x within the sliding window.
            // If the window is too far left, we shift the window to the right.
            if (x - arr[pivot] > arr[pivot + k] - x) 
                left = pivot + 1;
            else 
                right = pivot;
        }
        
        List<Integer> result = new ArrayList<>();
        for (int i = left; i < left + k; i++) {
            result.add(arr[i]);
        }
        return result;
    }
}