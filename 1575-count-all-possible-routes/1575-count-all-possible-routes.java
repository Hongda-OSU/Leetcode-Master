class Solution {
    long MOD = 1000_000_007;
    int[] locations;
    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        this.locations = locations;
        return (int) countRoutesDp(start, finish, fuel, new HashMap<>());
    }
    
    /// Use Return Type as Long - Since internal result may not fit Int limit before MOD 
    private long countRoutesDp(int start, int finish, int fuel, Map<String, Long> memo) {
        if(fuel < 0) return 0;
        long totalWays = 0;
        //// Start is Same as Finish - Add 1 and then Continue further
        if(start == finish) totalWays += 1; 
        /// Unique Key - Start And Remaining Fuel
        String key = start + "#" + fuel;
        if(memo.containsKey(key)) return memo.get(key);
        
        for(int nextLoc=0;nextLoc<locations.length;nextLoc++) {
            /// Continue Since previous start was same has next location
            if(nextLoc == start) continue;
            /// required fuel for this Path
            int reqFuel = Math.abs(locations[start] - locations[nextLoc]);
            if(reqFuel <= fuel) { /// Continue to this (nextLoc) location only if sufficient fuel is available
                totalWays += countRoutesDp(nextLoc, finish, fuel - reqFuel, memo) % MOD;
            }
        }
        /// MOD the result before Returning
        totalWays %= MOD;
        memo.put(key, totalWays);
        return totalWays;
    }
}