class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        int L = 10, len = s.length();
        Set<String> set = new HashSet<>(), output = new HashSet<>();
        for (int start = 0; start < len - L + 1; start++) {
            String str = s.substring(start, start + L);
            if (set.contains(str))
                output.add(str);
            set.add(str);
        }
        return new ArrayList<String>(output);
    }
}