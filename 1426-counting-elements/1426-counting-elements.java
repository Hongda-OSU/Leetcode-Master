class Solution {
    public int countElements(int[] arr) {
        int[] mapping = new int[1002];
        for (int i = 0; i < arr.length; i++)
            mapping[arr[i]]++;
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            int x = arr[i] + 1;
            if (mapping[x] > 0)
                result++;
        }
        return result;
    } 
}