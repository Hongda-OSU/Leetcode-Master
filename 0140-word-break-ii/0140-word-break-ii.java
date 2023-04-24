class Solution {
    protected Set<String> wordSet;
    protected ArrayList<ArrayList<ArrayList<Integer>>> dp;

    protected String inputString;
    protected ArrayList<String> result;

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

        inputString = s;
        dp = new ArrayList<ArrayList<ArrayList<Integer>>>(s.length() + 1);
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
                    ArrayList<Integer> newStop = new ArrayList();
                    newStop.add(startIndex);
                    newStop.add(endIndex);
                    stops.add(newStop);
                }
            }
            dp.set(endIndex, stops);
        }

        this.result = new ArrayList<String>();
        wordDFS("", s.length());
        return this.result;
    }

    protected void wordDFS(String sentence, Integer dpIndex) {
        if (dpIndex == 0) {
            result.add(sentence.strip());
            return;
        }

        for (List<Integer> wordIndex : dp.get(dpIndex)) {
            Integer start = wordIndex.get(0), end = wordIndex.get(1);
            String newSentence = inputString.substring(start, end) + " " + sentence;
            wordDFS(newSentence, start);
        }
    }
}