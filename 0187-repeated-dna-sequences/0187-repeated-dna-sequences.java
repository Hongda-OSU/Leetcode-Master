class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        int l = 10, len = s.length();
        Set<String> set = new HashSet<>(), output = new HashSet<>();
        for (int start = 0; start < len - l + 1; start++) {
            String str = s.substring(start, start + l);
            if (set.contains(str))
                output.add(str);
            set.add(str);
        }
        return new ArrayList<String>(output);
    }
}