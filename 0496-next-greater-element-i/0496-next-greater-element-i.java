class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>(); //LIFO
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums2) {
            // if num is greater than top elements in stack then it is the next greater element in nums2
            while (!stack.isEmpty() && stack.peek() < num) 
                // store num (key) next great number (value)
                map.put(stack.pop(), num);
            stack.add(num);
        }
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = map.getOrDefault(nums1[i], -1);
        } 
        return result;
    }
}