class Solution {
    public Map<Integer, List<Integer>> groupGraph;
    public Map<Integer, List<Integer>> itemGraph;
    public int[] groupsIndegree;
    public int[] itemsIndegree;
    
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        // using topo sort
        groupGraph = new HashMap<>();
        itemGraph = new HashMap<>();
        for (int i = 0; i < group.length; i++) {
            if (group[i] == -1)
                group[i] = m++;
        }
        for (int i = 0; i < m; i++) 
            groupGraph.put(i, new ArrayList<>());
        for (int i = 0; i < n; i++) 
            itemGraph.put(i, new ArrayList<>());
        groupsIndegree = new int[m];
        itemsIndegree = new int[n];
        buildGraphOfGroups(group, beforeItems, n);
        buildGraphOfItems(beforeItems, n);
        List<Integer> groupsList = topoSortUtil(groupGraph, groupsIndegree, m);
        List<Integer> itemsList = topoSortUtil(itemGraph, itemsIndegree, n);
        if (groupsList.size() == 0 || itemsList.size() == 0)
            return new int[0];
        Map<Integer, List<Integer>> groupsToItems = new HashMap<>();
        for (Integer item : itemsList)
            groupsToItems.computeIfAbsent(group[item], x -> new ArrayList<>()).add(item);
        int[] result = new int[n];
        int idx = 0;
        for (Integer grp : groupsList) {
            List<Integer> items = groupsToItems.getOrDefault(grp, new ArrayList<>());
            for (Integer item : items)
                result[idx++] = item;
        }
        return result;
    }

    public List<Integer> topoSortUtil(Map<Integer, List<Integer>> graph, int[] indegree, int k) {
        List<Integer> list = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int key : graph.keySet()) {
            if (indegree[key] == 0)
                queue.add(key);
        }
        while (!queue.isEmpty()) {
            int node = queue.poll();
            k--;
            list.add(node);
            for (int neighbor : graph.get(node)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0)
                    queue.offer(neighbor);
            }
        }
        return k == 0 ? list : new ArrayList<>();
    }

    public void buildGraphOfGroups(int[] group, List<List<Integer>> beforeItems, int n) {
        for (int i = 0; i < n; i++) {
            int toGroup = group[i];
            List<Integer> fromItems = beforeItems.get(i);
            for (int fromItem : fromItems) {
                int fromGroup = group[fromItem];
                if (fromGroup != toGroup) {
                    groupGraph.computeIfAbsent(fromGroup, x -> new ArrayList<>()).add(toGroup);
                    groupsIndegree[toGroup]++;
                }
            }
        }
    }

    public void buildGraphOfItems(List<List<Integer>> beforeItems, int n) {
        for (int i = 0; i < n; i++) {
            List<Integer> items = beforeItems.get(i);
            for (Integer item : items) {
                itemGraph.computeIfAbsent(item, x -> new ArrayList<>()).add(i);
                itemsIndegree[i]++;
            }
        }
    }
}