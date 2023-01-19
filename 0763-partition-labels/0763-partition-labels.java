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
                // Add partition length to output list
                partitions.add(partitionEnd - patitionStart + 1);
                // Reset partition
                patitionStart = i + 1;
                partitionEnd = i + 1;
            }
        }
        return partitions;
    }
}