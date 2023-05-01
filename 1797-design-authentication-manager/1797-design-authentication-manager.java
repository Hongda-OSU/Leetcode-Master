class AuthenticationManager {
    private TreeMap<Integer, String> treeMap = new TreeMap<>();
    private Map<String, Integer> expireTime = new HashMap<>();
    private static int life;

    public AuthenticationManager(int timeToLive) {
        this.life = timeToLive;
    }
    
    public void generate(String tokenId, int currentTime) {
        expireTime.put(tokenId, this.life + currentTime);
        treeMap.put(this.life + currentTime, tokenId);
    }
    
    public void renew(String tokenId, int currentTime) {
        int expire = expireTime.getOrDefault(tokenId, -1);
        var tail = treeMap.tailMap(currentTime + 1);
        if (!tail.isEmpty() && expire >= tail.firstKey()) {
            treeMap.remove(expire);
            treeMap.put(this.life + currentTime, tokenId);
            expireTime.put(tokenId, this.life + currentTime);
        }
    }
    
    public int countUnexpiredTokens(int currentTime) {
        return treeMap.tailMap(currentTime + 1).size();
    }
}

/**
 * Your AuthenticationManager object will be instantiated and called as such:
 * AuthenticationManager obj = new AuthenticationManager(timeToLive);
 * obj.generate(tokenId,currentTime);
 * obj.renew(tokenId,currentTime);
 * int param_3 = obj.countUnexpiredTokens(currentTime);
 */