class Solution {
    public char[][] reversiblePairs = {
        {'0', '0'}, {'1', '1'}, 
        {'6', '9'}, {'8', '8'}, {'9', '6'}
    };
    
    public List<String> generateStroboNumbers(int n, int finalLength) {
        if (n == 0) {
            // 0-digit strobogrammatic number is an empty string.
            return new ArrayList<>(List.of(""));
        }
        
        if (n == 1) {
            // 1-digit strobogrammatic numbers.
            return new ArrayList<>(List.of("0", "1", "8"));
        }
        
        List<String> prevStroboNums = generateStroboNumbers(n - 2, finalLength);
        List<String> currStroboNums = new ArrayList<>();
        
        for (String prevStroboNum : prevStroboNums) {
            for (char[] pair : reversiblePairs) {
                // We can only append 0's if it is not first digit.
                if (pair[0] != '0' || n != finalLength) {
                    currStroboNums.add(pair[0] + prevStroboNum + pair[1]);
                }
            }
        }
        
        return currStroboNums;
    }
    
    public List<String> findStrobogrammatic(int n) {
        return generateStroboNumbers(n, n);
    }
}