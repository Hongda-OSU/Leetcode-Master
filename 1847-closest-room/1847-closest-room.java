class Solution {
    public int[] closestRoom(int[][] rooms, int[][] queries) {
        int n = rooms.length, k = queries.length;
        Integer[] indexes = new Integer[k];
        for (int i = 0; i < k; i++)
            indexes[i] = i;
        Arrays.sort(rooms, (a, b) -> b[1] - a[1]);
        Arrays.sort(indexes, (a, b) -> queries[b][1] - queries[a][1]);
        TreeSet<Integer> roomIds = new TreeSet<>();
        int[] result = new int[k];
        int i = 0;
        for (int index : indexes) {
            while (i < n && rooms[i][1] >= queries[index][1])
                roomIds.add(rooms[i++][0]);
            result[index] = searchClosetRoomId(roomIds, queries[index][0]);
        }
        return result;
    }
    
    public int searchClosetRoomId(TreeSet<Integer> roomIds, int preferredId) {
        Integer floor = roomIds.floor(preferredId);
        Integer ceiling = roomIds.ceiling(preferredId);
        int resultAbs = Integer.MAX_VALUE, result = -1;
        if (floor != null) {
            result = floor;
            resultAbs = Math.abs(preferredId - floor);
        }
        if (ceiling != null && resultAbs > Math.abs(preferredId - ceiling))
            result = ceiling;
        return result;
    }
}