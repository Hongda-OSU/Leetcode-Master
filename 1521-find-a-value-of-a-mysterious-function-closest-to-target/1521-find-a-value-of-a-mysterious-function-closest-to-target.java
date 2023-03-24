class Solution {
    public int closestToTarget(int[] arr, int target) {
        int m = arr.length, result = Integer.MAX_VALUE;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            Set<Integer> tmp = new HashSet<>();
            tmp.add(arr[i]);
            for (int num : set)
                tmp.add(num & arr[i]);
            for (int num : tmp) 
                result = Math.min(result, Math.abs(num - target));
            set = tmp;
        }
        return result;
    }
}