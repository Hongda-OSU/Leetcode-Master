class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int low = 0, high = letters.length - 1;
        while (low <= high) {
            int pivot = (low + high) >>> 1;
            if (letters[pivot] <= target)
                low = pivot + 1;
            else 
                high = pivot - 1;
        }
        return letters[low % letters.length];
    }
}