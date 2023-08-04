class Solution {
    public int countElements(int[] arr) {
        int hash[] = new int [1002];
        for(int i = 0; i < arr.length; ++i) {
            hash[arr[i]]++;
        }
        int c = 0;
        for(int i = 0 ; i < arr.length; ++i){
            int x = arr[i] + 1;
            if(hash[x] > 0) {
                ++c;
            }
        }
        return c;
    }
}