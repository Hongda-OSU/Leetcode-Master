class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1)
            return s;
        StringBuilder sb = new StringBuilder();
        int n = s.length(), section = 2 * (numRows - 1);
        for (int row = 0; row < numRows; row++) {
            int index = row;
            while (index < n) {
                sb.append(s.charAt(index));
                if (row != 0 && row != numRows - 1) {
                    int between = section - 2 * row;
                    int secondIndex = index + between;
                    if (secondIndex < n) 
                        sb.append(s.charAt(secondIndex));
                }
                index += section;
            }
        }
        return sb.toString();
    }
}