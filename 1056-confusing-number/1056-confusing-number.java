class Solution {
    public boolean confusingNumber(int n) {
        Map<Integer, Integer> inverseMap = new HashMap<>() {{
            put(0, 0);
            put(1, 1);
            put(6, 9);
            put(8, 8);
            put(9, 6);
        }};
        int copy = n, temp = 0;
        while (copy > 0) {
            int result = copy % 10;
            if (!inverseMap.containsKey(result))
                return false;
            temp = temp * 10 + inverseMap.get(result);
            copy /= 10;
        }
        return temp != n;
    }
}