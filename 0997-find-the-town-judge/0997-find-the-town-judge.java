class Solution {
    public int findJudge(int n, int[][] trust) {
        if (n == 1 && trust.length == 0) return 1;
        int[] count = new int[n + 1];
        for (int i = 0; i < trust.length; i++) {
            // labeled ai trusts the person labeled bi
            count[trust[i][0]]--;
            // labeled bi is trusted by ai
            count[trust[i][1]]++;
        }
        for (int i = 0; i < count.length; i++) {
            // if any person has gained a trust of n-1 people, and trusts nobody, judge.
            if (count[i] == n - 1)
                return i;
        }
        return -1;
    }
}