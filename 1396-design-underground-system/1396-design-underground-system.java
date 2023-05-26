class UndergroundSystem {
    private Map<Integer, Info> activeTrips;
    private Map<String, Map<String, Detail>> analyticsDetails;

    public UndergroundSystem() {
        activeTrips = new HashMap<>();
        analyticsDetails = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        activeTrips.put(id, new Info(id, stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        Info activeTrip = activeTrips.remove(id);
        activeTrip.dest = stationName;
        activeTrip.endTime = t;
        Map<String, Detail> stationAnalytics = analyticsDetails.getOrDefault(activeTrip.src, new HashMap<>());
        Detail destinationDetails = stationAnalytics.getOrDefault(stationName, new Detail());
        destinationDetails.dest = stationName;
        destinationDetails.totalTime += activeTrip.endTime - activeTrip.startTime;
        destinationDetails.totalTrips++;
        stationAnalytics.put(destinationDetails.dest, destinationDetails);
        analyticsDetails.put(activeTrip.src, stationAnalytics);
    }
    
    public double getAverageTime(String startStation, String endStation) {
        Detail detail = analyticsDetails.getOrDefault(startStation, new HashMap<>())
            .getOrDefault(endStation, new Detail());
        long totalTime = detail.totalTime;
        long totalTrips = detail.totalTrips;
        return totalTrips == 0 ? 0 : (1.0 * totalTime) / totalTrips;
    }
}

class Info {
    public int userId;
    public String src, dest;
    public int startTime, endTime;
    
    public Info(int userId, String sourceStation, int startTimestamp) {
        this.userId = userId;
        this.src = sourceStation;
        this.startTime = startTimestamp;
    }
}

class Detail {
    public String src, dest;
    public long totalTrips, totalTime;
    
    public Detail() {
        
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */