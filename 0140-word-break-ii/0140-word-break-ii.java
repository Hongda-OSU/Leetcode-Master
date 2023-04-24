class Solution {
    protected Set<String> wordSet;

    private void updateCharSet(String s, HashSet<Character> charSet) {
        for (int i = 0; i < s.length(); ++i)
            charSet.add(s.charAt(i));
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        HashSet<Character> stringCharSet = new HashSet<Character>();
        updateCharSet(s, stringCharSet);

        HashSet<Character> wordCharSet = new HashSet<Character>();
        wordSet = new HashSet<>();
        for (String word : wordDict) {
            wordSet.add(word);
            updateCharSet(word, wordCharSet);
        }

        // quick check on the sets of characters
        if (!wordCharSet.containsAll(stringCharSet))
            return new ArrayList();

        ArrayList<ArrayList<ArrayList<Integer>>> dp =
                new ArrayList<ArrayList<ArrayList<Integer>>>(s.length() + 1);
        for (int i = 0; i < s.length() + 1; ++i) {
            ArrayList<ArrayList<Integer>> emptyList = new ArrayList<ArrayList<Integer>>();
            dp.add(emptyList);
        }
        ArrayList<Integer> start = new ArrayList<Integer>();
        start.add(0);
        dp.get(0).add(start);

        for (int endIndex = 1; endIndex < s.length() + 1; ++endIndex) {
            ArrayList<ArrayList<Integer>> stops = new ArrayList<ArrayList<Integer>>();

            // fill up the values in the dp array.
            for (int startIndex = 0; startIndex < endIndex; ++startIndex) {
                String word = s.substring(startIndex, endIndex);
                if (wordSet.contains(word)) {
                    for (List<Integer> subsentence : dp.get(startIndex)) {
                        ArrayList<Integer> copy = new ArrayList(subsentence);
                        copy.add(endIndex);
                        stops.add(copy);
                    }
                }
            }
            dp.set(endIndex, stops);
        }

        // reconstruct the words list from the positions of breaks/stops
        ArrayList<String> ret = new ArrayList<String>();
        for (List<Integer> stops : dp.get(s.length())) {
            StringBuffer sentence = new StringBuffer();
            for (int i = 0; i < stops.size() - 1; ++i) {
                sentence.append(s.substring(stops.get(i), stops.get(i + 1)) + " ");
            }
            ret.add(sentence.toString().strip());
        }

        return ret;
    }
}