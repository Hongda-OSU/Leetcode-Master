class Solution {
     public int maxDistance(List<List<Integer>> arrays) {
    int res = 0;
    //running min and max, use constrained values
    int min = 10001, max = -10001;
    
    for (int i = 0; i < arrays.size(); i++) {
      List<Integer> cur = arrays.get(i);
      //min and max elements for the current array
      int minEl = cur.get(0), maxEl = cur.get(cur.size() - 1);
      //get running max result among this max and prev min and prev max and
      //current min
      res = Math.max(res, Math.max(maxEl - min, max - minEl));
      //update running min/max
      min = Math.min(min, minEl);
      max = Math.max(max, maxEl);
    }
    return res;
  }
}