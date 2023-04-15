class Solution {
    public int evalRPN(String[] tokens) {
        int[] arr = new int[tokens.length / 2 + 1];
        int index = 0;
        for (String token : tokens) {
            switch (token) {
                case "+":
                    arr[index - 2] += arr[index - 1];
                    index--;
                    break;
                case "-":
                    arr[index - 2] -= arr[index - 1];
                    index--;
                    break;
                case "*":
                    arr[index - 2] *= arr[index - 1];
                    index--;
                    break;
                case "/":
                    arr[index - 2] /= arr[index - 1];
                    index--;
                    break;           
                default:
                    arr[index++] = Integer.parseInt(token);
                    break;
            }
        }
        return arr[0];
    }
}