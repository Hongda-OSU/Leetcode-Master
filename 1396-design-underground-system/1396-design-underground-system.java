class UndergroundSystem {
    static class TripInfo {
        int userId;
        String sourceStation, destinationStation;
        int startTimestamp, endTimestamp;

        public TripInfo(int usrId, String sourceStation, int startTimestamp) {
            this.userId = userId;
            this.sourceStation = sourceStation;
            this.startTimestamp = startTimestamp;
        }
    }

    static class TripsAnalyticDetails {
        String sourceStation, destinationStation;
        long totalTrips;
        long totalTime;

        public TripsAnalyticDetails() {}

    }

    Map<Integer, TripInfo> activeTrips;

    Map<String, Map<String, TripsAnalyticDetails>> analyticsDetails;

    public UndergroundSystem() {
        activeTrips = new HashMap<>();
        analyticsDetails = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        activeTrips.put(id, new TripInfo(id, stationName, t));
        
    }
    
    public void checkOut(int id, String stationName, int t) {
        TripInfo activeTrip = activeTrips.remove(id);
        activeTrip.destinationStation = stationName;
        activeTrip.endTimestamp = t;

         Map<String, TripsAnalyticDetails> stationAnalytics = analyticsDetails.getOrDefault(activeTrip.sourceStation, new HashMap<>());
         TripsAnalyticDetails destinationDetails = stationAnalytics.getOrDefault(stationName, new TripsAnalyticDetails());
         destinationDetails.destinationStation = stationName;
         destinationDetails.totalTime += activeTrip.endTimestamp - activeTrip.startTimestamp;
         destinationDetails.totalTrips++;

         stationAnalytics.put(destinationDetails.destinationStation, destinationDetails);
         analyticsDetails.put(activeTrip.sourceStation, stationAnalytics);
    }
    
    public double getAverageTime(String startStation, String endStation) {
        TripsAnalyticDetails details = analyticsDetails.getOrDefault(startStation, new HashMap<>()).getOrDefault(endStation, new TripsAnalyticDetails());
        long totalTime = details.totalTime;
        long totalTrips = details.totalTrips;
        return totalTrips == 0 ? 0 : (1.0 * totalTime) / totalTrips;
        
    }
}


/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */