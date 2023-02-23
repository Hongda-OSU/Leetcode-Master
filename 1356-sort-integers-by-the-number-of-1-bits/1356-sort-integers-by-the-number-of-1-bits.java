class Solution {
    class myComparator implements Comparator<int[]> {
        public int compare(int[] a, int[] b) {
            if (a[1] != b[1]) 
                return a[1] - b[1];
            else
                return a[0] - b[0];
        }
    }
    
    public int[] sortByBits(int[] arr) {
        int[][] count = new int[arr.length][2];
        for (int i = 0; i < arr.length; i++) {
            count[i][0] = arr[i];
            count[i][1] = Integer.bitCount(arr[i]);
        }
        Arrays.sort(count, new myComparator());
        for (int i = 0; i < arr.length; i++)
            arr[i] = count[i][0];
        return arr;
    }
}