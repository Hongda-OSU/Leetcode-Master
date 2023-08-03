class Solution {
    public int numKLenSubstrNoRepeats(String s, int k) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        if (n < k)
            return 0;
        int repeated = 0;
        int[] count = new int[26];
        // check first k characters 
        for (int i = 0; i < k; i++) {
            count[arr[i] - 'a']++;
            if (count[arr[i] - 'a'] == 2) 
                repeated++;
        }
        // if first k charcters have no repeat, then result is 1
        int result = repeated > 0 ? 0 : 1;
        
        for (int i = k; i < n; i++) {
            // remove old character
            count[arr[i - k] - 'a']--;
            if (count[arr[i - k] - 'a'] == 1)
                repeated--;
            // add new character
            count[arr[i] - 'a']++;
            if (count[arr[i] - 'a'] == 2)
                repeated++;
            if (repeated == 0)
                result++;
        }
        return result;
    }
}