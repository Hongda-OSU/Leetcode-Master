class AuthenticationManager {

    private TreeMap<Integer, String> tm = new TreeMap<>();
    private Map<String, Integer> expireTime = new HashMap<>();
    private int life;
    
    public AuthenticationManager(int timeToLive) {
        life = timeToLive;
    }
    
    public void generate(String tokenId, int currentTime) {
        expireTime.put(tokenId, life + currentTime);
        tm.put(life + currentTime, tokenId);         
    }
    
    public void renew(String tokenId, int currentTime) {
        int expire = expireTime.getOrDefault(tokenId, -1);
        var tail = tm.tailMap(currentTime + 1);
        if (!tail.isEmpty() && expire >= tail.firstKey()) {
            tm.remove(expire);
            tm.put(life + currentTime, tokenId);
            expireTime.put(tokenId, life + currentTime);
        }
    }
    
    public int countUnexpiredTokens(int currentTime) {
        return tm.tailMap(currentTime + 1).size();
    }
}

/**
 * Your AuthenticationManager object will be instantiated and called as such:
 * AuthenticationManager obj = new AuthenticationManager(timeToLive);
 * obj.generate(tokenId,currentTime);
 * obj.renew(tokenId,currentTime);
 * int param_3 = obj.countUnexpiredTokens(currentTime);
 */