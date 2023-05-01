class AuthenticationManager {
 private Map<String, Integer> expiry = new HashMap<>();
    private int life;
    
    public AuthenticationManager(int timeToLive) {
        life = timeToLive;
    }
    
    public void generate(String tokenId, int currentTime) {
        expiry.put(tokenId, life + currentTime);
    }
    
    public void renew(String tokenId, int currentTime) {
        if (expiry.getOrDefault(tokenId, -1) > currentTime) {
            expiry.put(tokenId, life + currentTime);
        }
    }
    
    public int countUnexpiredTokens(int currentTime) {
        expiry.entrySet().removeIf(e -> e.getValue() <= currentTime);
        return expiry.size();
    }
}

/**
 * Your AuthenticationManager object will be instantiated and called as such:
 * AuthenticationManager obj = new AuthenticationManager(timeToLive);
 * obj.generate(tokenId,currentTime);
 * obj.renew(tokenId,currentTime);
 * int param_3 = obj.countUnexpiredTokens(currentTime);
 */