class Solution {
    public boolean canWin(String currentState) {
        int curlen = 0, maxlen = 0;
        List<Integer> boardInitState = new ArrayList<>();
        for (int i = 0; i < currentState.length(); ++i) {
            if (currentState.charAt(i) == '+') {
                curlen++;
            }
            if (i + 1 == currentState.length() || currentState.charAt(i) == '-') {
                if (curlen >= 2) {
                    boardInitState.add(curlen);
                }
                maxlen = Math.max(maxlen, curlen);
                curlen = 0;
            }
        }
        int[] g = new int[maxlen + 1];
        for (int len = 2; len <= maxlen; ++len) {
            Set<Integer> gsub = new HashSet<>();
            for (int lenFirstGame = 0; lenFirstGame < len / 2; ++lenFirstGame) {
                int lenSecondGame = len - lenFirstGame - 2;
                gsub.add(g[lenFirstGame] ^ g[lenSecondGame]);
            }
            g[len] = firstMissingNumber(gsub);
        }

        int gFinal = 0;
        for (int s : boardInitState) {
            gFinal ^= g[s];
        }
        return gFinal != 0;
    }

    private int firstMissingNumber(Set<Integer> lut) {
        int m = lut.size();
        for (int i = 0; i < m; ++i) {
            if (!lut.contains(i)) {
                return i;
            }
        }
        return m;
    }
}