class Solution {
    public int maximizeSweetness(int[] sweetness, int k) {
        int numPeople = k + 1;
        int left = Arrays.stream(sweetness).min().getAsInt();
        int right = Arrays.stream(sweetness).sum() / numPeople;
        while (left < right) {
            int pivot = (left + right + 1) >>> 1;
            int currSweetness = 0;
            int peopleWithChocolate = 0;
            for (int s : sweetness) {
                currSweetness += s;
                if (currSweetness >= pivot) {
                    peopleWithChocolate += 1;
                    currSweetness = 0;
                }
            }
            if (peopleWithChocolate >= numPeople)
                left = pivot;
            else 
                right = pivot - 1;
        }
        return right;
    }
}