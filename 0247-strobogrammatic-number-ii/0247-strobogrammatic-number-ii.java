class Solution {
    public List<String> findStrobogrammatic(int n) {
        return findStrobogrammaticHelper(n, n);
    }
    
    private List<String> findStrobogrammaticHelper(int m, int n) {
        if (m == 0)
            return new ArrayList<>(Arrays.asList(""));
        if (m == 1) 
            return new ArrayList<>(Arrays.asList("0", "1", "8"));
        List<String> list = findStrobogrammaticHelper(m - 2, n);
        List<String> result = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i);
            if (m != n)
                result.add("0" + str + "0");
            result.add("1" + str + "1");
            result.add("6" + str + "9");
            result.add("8" + str + "8");
            result.add("9" + str + "6");
        }
        return result;
    }
}