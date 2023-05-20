class WordDistance {

  HashMap<String,TreeSet<Integer>> map = new HashMap<>();	 
    public WordDistance(String[] words) {
        	int len = words.length;
	        for(int i=0; i<len; i++){
	        	TreeSet<Integer> ls = map.get(words[i]);
	        	if(ls==null) ls=new TreeSet<>();
	        	ls.add(i);
	        	map.put(words[i], ls);
	        }
    } 
	    public int shortest(String word1, String word2) {
	        TreeSet<Integer> tree_1 = map.get(word1);
	        TreeSet<Integer> tree_2 = map.get(word2);
	        int result=Integer.MAX_VALUE;
	        for(int i:tree_1){
	        	Integer floor = tree_2.floor(i);
	        	Integer ceiling = tree_2.ceiling(i);
	        	if(floor!=null) result=Math.min(result, Math.abs(i-floor));
	        	if(ceiling!=null) result=Math.min(result, Math.abs(i-ceiling));
	        }
	        return result;
	    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(wordsDict);
 * int param_1 = obj.shortest(word1,word2);
 */