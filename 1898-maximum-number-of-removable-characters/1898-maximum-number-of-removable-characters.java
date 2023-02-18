class Solution {
    public int maximumRemovals(String s, String p, int[] removable) {
        int left = 0, right = removable.length;
        int[] map = new int[s.length()];
        Arrays.fill(map, removable.length);
        for (int i = 0; i < removable.length; i++) 
            map[removable[i]] = i;
        while (left < right) {
            int pivot = (left + right + 1) >>> 1, j = 0;
            for (int i = 0; i < s.length() && j < p.length(); i++) {
                if (map[i] >= pivot && s.charAt(i) == p.charAt(j))
                    j++;
            }
            if (j == p.length())
                left = pivot;
            else 
                right = pivot - 1;
        }
        return left;
    }
}