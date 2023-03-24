class MajorityChecker {
    public int digits = 15;
    public int[][] preSum;
    public ArrayList<Integer>[] pos;
    
    public MajorityChecker(int[] arr) {
        int n = arr.length;
        preSum = new int[n + 1][digits];
        pos = new ArrayList[20001];
        for (int i = 0; i < n; i++) {
            int k = arr[i];
            if (pos[k] == null)
                pos[k] = new ArrayList<>();
            pos[k].add(i);
            for (int j = 0; j < digits; j++) {
                preSum[i + 1][j] = preSum[i][j] + (k & 1);
                k >>= 1;
            }
        }
    }
    
    public int query(int left, int right, int threshold) {
        int result = 0;
        for (int i = digits - 1; i >= 0; i--) {
            int count = preSum[right + 1][i] - preSum[left][i];
            int b = 1;
            if (count >= threshold)
                b = 1;
            else if (right - left + 1 - count >= threshold)
                b = 0;
            else
                return -1;
            result = (result << 1) + b;
        }
        ArrayList<Integer> list = pos[result];
        if (list == null)
            return -1;
        int l = floor(list, left - 1);
        int r = floor(list, right);
        if (r - l >= threshold)
            return result;
        return -1;
    }
    
    public int floor(ArrayList<Integer> list, int n) {
        int left = 0, right = list.size() - 1;
        while (left <= right) {
            int pivot = left + (right - left) / 2;
            int idx = list.get(pivot);
            if (idx == n)
                return pivot;
            else if (idx < n)
                left = pivot + 1;
            else 
                right = pivot - 1;
        }
        return right;
    }
}

/**
 * Your MajorityChecker object will be instantiated and called as such:
 * MajorityChecker obj = new MajorityChecker(arr);
 * int param_1 = obj.query(left,right,threshold);
 */