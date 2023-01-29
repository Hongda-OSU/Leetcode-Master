class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int asteroid : asteroids) {
            if (asteroid > 0) {
                // if positive push to stack
                stack.push(asteroid);
            } else {
                //the negative asteroid weight > positive asteroid, so pop the prev asteroid 
                while (!stack.isEmpty() && stack.peek() > 0 && Math.abs(asteroid) > stack.peek()) {
                    stack.pop();
                }
                // push the current asteroid as it burst'ed all the prev smaller asteroids
                if (stack.isEmpty() || stack.peek() < 0) 
                    stack.push(asteroid);
                // when the positive and negative asteroid weights are equal, remove the stack top
                else if (asteroid + stack.peek() == 0) 
                    stack.pop();
            } 
        }
        int[] result = new int[stack.size()];
        // fill in the result array from the final and left over asteroids
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return result;
    }
}