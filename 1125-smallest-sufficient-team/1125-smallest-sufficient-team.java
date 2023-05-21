class Solution {
    private List<Integer> sol = new ArrayList<>();
    
    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        Map<String, Integer> idx = new HashMap<>(); 
        int n = 0;
        for (String s : req_skills) 
            idx.put(s, n++);
        int[] pe = new int[people.size()];
        for (int i = 0; i < pe.length; i++) {
            for (String p : people.get(i)) {
                int skill = idx.get(p);
                pe[i] += 1 << skill;
            }
        } 
        search(0, pe, new ArrayList<Integer>(), n);  
        int[] ans = new int[sol.size()];
        for (int i = 0; i < sol.size(); i++) 
            ans[i] = sol.get(i);
        return ans;
    }
    
    private void search(int cur, int[] pe, List<Integer> onesol, int n) { 
        if (cur == (1 << n) - 1) {  
            if (sol.size() == 0 || onesol.size() < sol.size()) 
                sol = new ArrayList<>(onesol);
            return;
        }
        if (sol.size() != 0 && onesol.size() >= sol.size()) 
            return;    
        int zeroBit = 0;
        while (((cur >> zeroBit) & 1) == 1) 
            zeroBit++;   
        for (int i = 0; i < pe.length; i++) {
            int per = pe[i];
            if (((per >> zeroBit) & 1) == 1) {
                onesol.add(i); 
                search(cur | per, pe, onesol, n);
                onesol.remove(onesol.size() - 1);  
            }
        } 
    }
}