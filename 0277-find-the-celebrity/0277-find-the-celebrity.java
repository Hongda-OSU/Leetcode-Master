/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    private int numberOfPeople;
    
    public int findCelebrity(int n) {
        numberOfPeople = n;
        int celebrityCandidate = 0;
        for (int i = 0; i < n; i++) {
            if (knows(celebrityCandidate, i)) {
                celebrityCandidate = i;
            }
        }
        if (isCelebrity(celebrityCandidate))
            return celebrityCandidate;
        return -1;
    }
    
    private boolean isCelebrity(int k) {
        for (int i = 0; i < numberOfPeople; i++) {
            if (i == k)
                continue;
            if (knows(k, i) || !knows(i, k))
                return false;
        }
        return true;
    }
}