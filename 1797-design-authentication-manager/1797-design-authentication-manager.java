class AuthenticationManager {

     int time=0;

    HashMap<String,Integer>mp=new HashMap<>();

    public AuthenticationManager(int timeToLive) {
        
    time=timeToLive;

    }
    
    public void generate(String tokenId, int currentTime) {
        
    mp.put(tokenId,currentTime+time);

    }
    
    public void renew(String tokenId, int currentTime) {
        
    if(!mp.containsKey(tokenId)||mp.get(tokenId)<=currentTime)
    {
    return;
    }

    mp.put(tokenId,currentTime+time);

    }
    
    public int countUnexpiredTokens(int currentTime) {
    
    List<String>lr=new ArrayList<>(mp.keySet());
    
    for(int i=0;i<lr.size();i++){
    
    if(mp.get(lr.get(i))<=currentTime)mp.remove(lr.get(i));

    }

    return mp.size();
    
    }
}

/**
 * Your AuthenticationManager object will be instantiated and called as such:
 * AuthenticationManager obj = new AuthenticationManager(timeToLive);
 * obj.generate(tokenId,currentTime);
 * obj.renew(tokenId,currentTime);
 * int param_3 = obj.countUnexpiredTokens(currentTime);
 */