class Solution {
   public int closestToTarget(int[] arr, int target) {
    int n = arr.length, min = Integer.MAX_VALUE;

    // ands[i]: unique AND values of arr[i...]
    // the size of ands[i] is at most ceil(log(arr[i])), i.e. arr[i].bitCount()
    Set<Integer>[] ands = new Set[n];
    for (int i = 0; i < n; i++) {
        ands[i] = new HashSet<>();
    }

    ands[n - 1].add(arr[n - 1]);

    // computes ands[i] from ands[i + 1]
    for (int i = n - 2; i >= 0; i--) {   
        ands[i].add(arr[i]);
        for (int v: ands[i + 1]) {
            ands[i].add(arr[i] & v);
        }
    }

    for (var a : ands) {
        for (int v : a) {
            min = Math.min(min, Math.abs(v - target));
        }
    }

    return min;
}
}