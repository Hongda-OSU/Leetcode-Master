class Solution {
    public List<List<Integer>> findRLEArray(int[][] encoded1, int[][] encoded2) {
        int p1 = 0, p2 = 0, idx1 = 0, idx2 = 0;
        List<List<Integer>> result = new ArrayList<>();
        while (idx1 < encoded1.length && idx2 < encoded2.length) {
            int freq1 = encoded1[idx1][1] - p1;
            int freq2 = encoded2[idx2][1] - p2;
            int freq = Math.min(freq1, freq2);
            p1 += freq; p2 += freq;
            int prod = encoded1[idx1][0] * encoded2[idx2][0];
            int size = result.size();
            // if current product is same as the most recent one in the result, concat it
            if (size > 0 && result.get(size - 1).get(0) == prod) {
                freq += result.get(size - 1).get(1);
                result.remove(size - 1);
            }
            result.add(Arrays.asList(prod, freq));
            if (p1 == encoded1[idx1][1]) {
                idx1++;
                p1 = 0;
            }
            if (p2 == encoded2[idx2][1]) {
                idx2++;
                p2 = 0;
            }
        }
        return result;
    }
}