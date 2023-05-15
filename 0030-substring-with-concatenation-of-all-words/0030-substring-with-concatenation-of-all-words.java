class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (words == null || words.length == 0 || s.length() == 0)
            return result;
        int wordLen = words[0].length(), numWord = words.length, window = wordLen * numWord, sLen = s.length();
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) 
            map.put(word, map.getOrDefault(word, 0) + 1);
        for (int i = 0; i < wordLen; i++) {
            HashMap<String, Integer> curr = new HashMap<>();
            for (int j = i, count = 0, start = i; j + wordLen <= sLen; j += wordLen) {
                if (start + window > sLen)
                    break;
                String word = s.substring(j, j + wordLen);
                if (!map.containsKey(word)) {
                    curr.clear();
                    count = 0;
                    start = j + wordLen;
                } else {
                    if (j == start + window) {
                        String prevWord = s.substring(start, start + wordLen);
                        start += wordLen;
                        int val = curr.get(prevWord);
                        if (val == 1)
                            curr.remove(prevWord);
                        else
                            curr.put(prevWord, val - 1);
                        if (val - 1 >= map.get(prevWord))
                            count--;
                    }
                    curr.put(word, curr.getOrDefault(word, 0) + 1);
                    if (curr.get(word) > map.get(word))
                        count++;
                    if (count == 0 && start + window == j + wordLen)
                        result.add(start);
                }
            }
        }
        return result;
    }
}