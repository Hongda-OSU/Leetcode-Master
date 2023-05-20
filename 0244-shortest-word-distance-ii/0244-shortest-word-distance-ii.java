class WordDistance {

   HashMap<String,List<Integer>> map = new HashMap<>();	 	
	 	public WordDistance(String[] words) {
	 		int len = words.length;
	        for(int i=0; i<len; i++){
	        	List<Integer> ls = map.get(words[i]);
	        	if(ls==null) ls=new ArrayList<>();
	        	ls.add(i);
	        	map.put(words[i], ls);
	        }
	    }
	    
	    public int shortest(String word1, String word2) {
	    	List<Integer> list_1 = map.get(word1);
	    	List<Integer> list_2 = map.get(word2); 
	    	int size = list_2.size();
	        int result=Integer.MAX_VALUE;
	        for(int i:list_1){
	        	int index = Collections.binarySearch(list_2, i);
	        	if(index<0) index=-(index+1);
	        	if(index>0) result=Math.min(Math.abs(i-list_2.get(index-1)), result);
	        	if(index<size) result=Math.min(Math.abs(i-list_2.get(index)), result); 
	        }
	        return result;
	    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(wordsDict);
 * int param_1 = obj.shortest(word1,word2);
 */