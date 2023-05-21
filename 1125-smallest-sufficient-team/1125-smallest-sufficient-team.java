class Solution {
    public List<Integer> list = new ArrayList<>();
    
    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        Map<String, Integer> map = new HashMap<>();
        int n = 0;
        for (String str : req_skills)
            map.put(str, n++);
        int[] p = new int[people.size()];
        for (int i = 0; i < p.length; i++) {
            for (String s : people.get(i)) {
                int skill = map.get(s);
                p[i] += 1 << skill;
            }
        }
        search(0, p, new ArrayList<>(), n);
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++)
            result[i] = list.get(i);
        return result;
    }
    
    public void search(int curr, int[] people, List<Integer> l, int n) {
        if (curr == (1 << n) - 1) {
            if (list.size() == 0 || l.size() < list.size())
                list = new ArrayList<>(l);
            return;
        }
        if (list.size() != 0 && l.size() > list.size())
            return;
        int zero = 0;
        while (((curr >> zero) & 1) == 1)
            zero++;
        for (int i = 0; i < people.length; i++) {
            int p = people[i];
            if (((p >> zero) & 1) == 1) {
                l.add(i);
                search(curr | p, people, l, n);
                l.remove(l.size() - 1);
            }
        }
    } 
}