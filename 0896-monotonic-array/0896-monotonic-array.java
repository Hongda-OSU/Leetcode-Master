class Solution {
    public boolean isMonotonic(int[] A) {
        if (A.length == 1) return true;
        if (A[0] < A[1]) return isIncreasing(A);
        else if (A[0] > A[1]) return isDecreasing(A);
        else {
            if (isIncreasing(A)) return true;
            return isDecreasing(A);
        }
    }
    
    public boolean isIncreasing(int[] A){
        for (int i = 0; i < A.length-1; i++){
            if (!(A[i] <= A[i+1])) return false;
        }
        return true;
    }
    
    public boolean isDecreasing(int[] A){
        for (int i = 0; i < A.length-1; i++){
            if (!(A[i] >= A[i+1])) return false;
        }
        return true;
    }
}