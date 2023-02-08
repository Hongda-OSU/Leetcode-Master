class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int low = 0, high = numbers.length - 1;
        while (low < high) {
            int temp = numbers[low] + numbers[high];
            if (temp == target) 
                break;
            else if (temp < target) 
                low++;
            else 
                high--;
        }
        return new int[] {low + 1, high + 1};
    }
}