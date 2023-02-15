class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int low = 0, high = position[position.length - 1] - position[0], result = 0;
        while (low <= high) {
            int pivot = (low + high) >>> 1;
            if (helper(position, pivot, m)) {
                result = pivot;
                low = pivot + 1;
            } else {
                high = pivot - 1;
            }
        }
        return result;
    }
    
    public boolean helper(int[] position, int pivot, int m) {
        int prev = position[0];
        m--;
        for (int i = 1; i < position.length; i++) {
            if (position[i] - prev >= pivot) {
                m--;
                if (m == 0)
                    return true;
                prev = position[i];
            }
        }        
        return m == 0;
    }
}