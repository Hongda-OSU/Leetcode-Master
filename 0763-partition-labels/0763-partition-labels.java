class Solution {
    public List<Integer> partitionLabels(String s) {
        // a map of character to its last index
        int[] mapping = new int[26];
        for (int i = 0; i < s.length(); i++) {
            mapping[s.charAt(i) - 'a'] = i;
        }
        List<Integer> partitions = new ArrayList<>();
        int patitionStart = 0, partitionEnd = 0;
        for (int i = 0; i < s.length(); i++) {
            partitionEnd = Math.max(partitionEnd, mapping[s.charAt(i) - 'a']);
            // Reached current partition end index
            if (i == partitionEnd) {
                partitions.add(partitionEnd - patitionStart + 1);
                patitionStart = i + 1;
                partitionEnd = i + 1;
            }
        }
        return partitions;
    }
}