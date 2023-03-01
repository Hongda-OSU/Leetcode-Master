class Solution {
    public int[] avoidFlood(int[] rains) {
        Map<Integer, Integer> full = new HashMap<>();
        TreeSet<Integer> zeros = new TreeSet<>();
        int[] result = new int[rains.length];
        for (int i = 0; i < rains.length; i++) {
            if (rains[i] == 0) {
                zeros.add(i);
                result[i] = 1;
            } else {
                if (full.containsKey(rains[i])) {
                    int lastFull = full.get(rains[i]);
                    Integer dryPos = zeros.ceiling(lastFull);
                    if (dryPos == null)
                        return new int[0];
                    result[dryPos] = rains[i];
                    zeros.remove(dryPos);
                } 
                result[i] = -1;
                full.put(rains[i], i);
            }
        }
        return result;
    }
}