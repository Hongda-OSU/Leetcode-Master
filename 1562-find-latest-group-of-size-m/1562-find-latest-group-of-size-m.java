class Solution {
    public int findLatestStep(int[] arr, int m) {
        int size = arr.length;
        if (m == size)
            return size;
        TreeSet<Integer> set = new TreeSet<>();
        set.add(0);
        set.add(size + 1);
        for (int i = size - 1; i >= 0; i--) {
            //  the greatest element in this set less than or equal to the given element
            int left = set.floor(arr[i]);
            //  the least element in this set greater than or equal to the given element
            int right = set.ceiling(arr[i]);
            if (arr[i] - left - 1 == m || right - arr[i] - 1 == m)
                return i;
            set.add(arr[i]);
        }
        return -1;
    }
}