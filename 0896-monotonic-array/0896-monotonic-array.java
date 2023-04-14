class Solution {
    public boolean isMonotonic(int[] arr) {
        if (arr[arr.length-1] < arr[0])
            reverse(arr);
        
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i-1]) 
                return false;
        }
        return true;
    }
    
    private void reverse(int[] arr) {
        for (int i = 0; i < arr.length/2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
    }
}