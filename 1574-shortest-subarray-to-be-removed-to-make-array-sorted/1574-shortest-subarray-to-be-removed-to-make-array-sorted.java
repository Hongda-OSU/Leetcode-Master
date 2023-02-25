class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (right > 0 && arr[right] >= arr[right - 1])
            right--;
        //whole array sorted
        if (right == 0)
            return 0;
        int result = right;
        while (left < right) {
            //Move the window such that arr[left] <= arr[right]
            while (right < arr.length && arr[left] > arr[right])
                right++;
            //Remove the subarray between left and right index and update the minimum 
            result = Math.min(result, right - left - 1);
            //The subarray arr[0...left] is sorted, 
            // then remove the right side completely and update result if minimum
            if (arr[left] <= arr[left + 1])
                result = Math.min(result, arr.length - (left + 2));
            else 
                break;
            left++;
        }
        return result;
    }
}