class Solution {
    public String getHint(String secret, String guess) {
        int bulls = 0, cows = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < secret.length(); i++) {
            char s = secret.charAt(i);
            char g = guess.charAt(i);
            if (s == g) {
                bulls++;
            } else {
                // cow is s == g in wrong position
                // cow happen when s < 0 => guess have more s
                // or g > 0 => secret have more g
                if (map.getOrDefault(s, 0) < 0) 
                    cows++;
                if (map.getOrDefault(g, 0) > 0)
                    cows++;
                map.put(s, map.getOrDefault(s, 0) + 1);
                map.put(g, map.getOrDefault(g, 0) - 1);
            } 
        }
        return new String(bulls + "A" + cows + "B");
    }
}