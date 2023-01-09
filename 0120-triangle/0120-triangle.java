class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        for (int row = 1; row < triangle.size(); row++) {
             for (int column = 0; column < row + 1; column++) {
                 int smallestAbove = Integer.MAX_VALUE;
                 // first, set smallest value to the upperleft one
                 if (column > 0) 
                     smallestAbove = triangle.get(row - 1).get(column - 1);
                 // then determine the smallest value should be the upperright one
                 if (column < row)
                     smallestAbove = Math.min(smallestAbove, triangle.get(row - 1).get(column));
                 // replace current value with smallest path
                 int path = smallestAbove + triangle.get(row).get(column);
                 triangle.get(row).set(column, path);
             }
        }
        return Collections.min(triangle.get(triangle.size() - 1));
    }
}