class Solution {
	private final Map<String, Boolean> map = new HashMap<>();
	public String longestWord(String[] words) {
		Set<String> dictionary = new HashSet<>();
		for(String word : words) {
			dictionary.add(word);
		}
		//sort array by length decending and lexicographically order 
		Arrays.sort(words, (a,b) -> a.length()!=b.length() ? b.length() - a.length() : a.compareTo(b));
		for(String s : words) {
			if(dfs(s, 0, dictionary)) return s;
		}
		return "";
	}

private boolean dfs(String input, int index, Set<String> dictionary) {
    if(map.containsKey(input)) return map.get(input);
    if(index==input.length()) {
        map.put(input, true);
        return true;
    }
    //move to next index to search longer prefix
    if(dictionary.contains(input.substring(0,index+1))) {
        return dfs(input, index+1, dictionary);
    } 
    return false;
}
}