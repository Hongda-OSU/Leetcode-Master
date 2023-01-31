class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] seen = new boolean[rooms.size()];
        seen[0] = true;
        Stack<Integer> visitedRooms = new Stack<>();
        visitedRooms.push(0);
        int count = 1; // room 0 is opened
        while (!visitedRooms.isEmpty()) {
            int visitedRoom = visitedRooms.pop();
            // get all the keys in that visited room, which also represent the room going to be visited
            for (int room : rooms.get(visitedRoom)) {
                if (!seen[room]) {
                    visitedRooms.push(room); // key i to room i added
                    seen[room] = true;
                    count++;
                }
            }
        }
        return count == rooms.size();
    }
}