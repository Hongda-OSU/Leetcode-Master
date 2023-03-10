class Solution {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        int n = plantTime.length;
        Pair[] flowerTime = new Pair[n];
        for (int i = 0; i < n; i++)
            flowerTime[i] = new Pair(plantTime[i], growTime[i]);
        Arrays.sort(flowerTime, (a, b) -> b.growTime - a.growTime);
        int plantingDays = 0, totalDays = 0;
        for (Pair pair : flowerTime) {
            totalDays = Math.max(totalDays, plantingDays + pair.plantTime + pair.growTime);
            plantingDays += pair.plantTime;
        }
        return totalDays;
    }
}

class Pair {
    public int plantTime;
    public int growTime;
    
    public Pair(int plantTime, int growTime) {
        this.plantTime = plantTime;
        this.growTime = growTime;
    }
}