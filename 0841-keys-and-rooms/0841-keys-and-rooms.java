class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] seen = new boolean[rooms.size()];
        seen[0] = true;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int count = 1; // room 0 is opened
        while (!stack.isEmpty()) {
            int key = stack.pop();
            for (int room : rooms.get(key)) {
                if (!seen[room]) {
                    stack.push(room); // key i to room i added
                    seen[room] = true;
                    count++;
                }
            }
        }
        return count == rooms.size();
    }
}