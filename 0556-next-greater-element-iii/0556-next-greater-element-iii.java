class Solution {
    public int nextGreaterElement(int i) {
        char[] arr = String.valueOf(i).toCharArray();
        int m = arr.length - 2;
        while (m >= 0 && arr[m] >= arr[m + 1])
            m--;
        if (m == -1)
            return -1;
        int n = arr.length - 1;
        while (arr[n] <= arr[m])
            n--;
        swap(arr, m, n);
        Arrays.sort(arr, m + 1, arr.length);
        long result = Long.parseLong(new String(arr));
        if (result > Integer.MAX_VALUE)
            return -1;
        else
            return (int)result;
    }
    
    private void swap(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}