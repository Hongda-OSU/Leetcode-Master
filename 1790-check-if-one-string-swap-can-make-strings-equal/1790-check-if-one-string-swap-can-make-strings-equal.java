class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        int[] arr1 = new int[26], arr2 = new int[26];
        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            char ch1 = s1.charAt(i), ch2 = s2.charAt(i);
            if (ch1 != ch2) count++;
            if (count > 2) return false;
            arr1[ch1 - 'a']++;
            arr2[ch2 - 'a']++;
        }
        return Arrays.equals(arr1, arr2);
    }
}