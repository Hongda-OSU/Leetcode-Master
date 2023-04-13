class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        HashMap<String, Integer> wordMap = new HashMap<>();
        Set<Integer> set = new TreeSet<>();
        int n = words.length;
        for (int i = 0; i < n; i++) {
            wordMap.put(words[i], i);
            set.add(words[i].length());
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int len = words[i].length();
            String reverse = new StringBuilder(words[i]).reverse().toString();
            if (wordMap.containsKey(reverse) && wordMap.get(reverse) != i)
                result.add(Arrays.asList(i, wordMap.get(reverse)));
            for (Integer num : set) {
                if (num == len)
                    break;
                if (isPalindrome(reverse, 0, len - num - 1)) {
                    String str = reverse.substring(len - num);
                    if (wordMap.containsKey(str))
                        result.add(Arrays.asList(i, wordMap.get(str)));
                }
                if (isPalindrome(reverse, num, len - 1)) {
                    String str = reverse.substring(0, num);
                    if (wordMap.containsKey(str))
                        result.add(Arrays.asList(wordMap.get(str), i));
                }
            }
        }
        return result;
    }
    
    private boolean isPalindrome(String str, int left, int right) {
        while (left < right) {
            if (str.charAt(left++) != str.charAt(right--)) 
                return false;
        }
        return true;
    }
}