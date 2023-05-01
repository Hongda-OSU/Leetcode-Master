class AuthenticationManager {

     private final Map<String, Pair<Integer,Integer>> slotTimeTokens;
    private final int timeToLive;

    public AuthenticationManager(int timeToLive) {
        this.timeToLive = timeToLive;
        this.slotTimeTokens = new HashMap<>();
    }
    
    public void generate(String tokenId, int currentTime) {
        slotTimeTokens.put(tokenId, new Pair<>(currentTime, currentTime + timeToLive));
    }
    
    public void renew(String tokenId, int currentTime) {
        Pair<Integer,Integer> pair = slotTimeTokens.get(tokenId);
        if(pair == null){
            return;
        }

        if(currentTime >= pair.getValue()){
            return;
        }

        slotTimeTokens.put(tokenId, new Pair<>(currentTime, currentTime + timeToLive));
    }
    
    public int countUnexpiredTokens(int currentTime) {
        int cnt = 0;
        return (int) slotTimeTokens.values().stream().filter(p -> p.getValue() > currentTime).count();
    }


    class Pair<K,V>{

        private K key;
        private V value;

        public Pair(K key, V value){
            this.key = key;
            this.value = value;
        }

        public K getKey(){
            return this.key;
        }

        public V getValue(){
            return this.value;
        }

    }
}

/**
 * Your AuthenticationManager object will be instantiated and called as such:
 * AuthenticationManager obj = new AuthenticationManager(timeToLive);
 * obj.generate(tokenId,currentTime);
 * obj.renew(tokenId,currentTime);
 * int param_3 = obj.countUnexpiredTokens(currentTime);
 */