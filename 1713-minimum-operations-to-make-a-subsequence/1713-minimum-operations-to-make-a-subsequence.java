class Solution {
    public int minOperations(int[] target, int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < target.length; i++)
            map.put(target[i], i);
        ArrayList<Integer> list = new ArrayList<>();
        for (int num : arr) {
            if (!map.containsKey(num))
                continue;
            if (list.size() == 0 || map.get(num) > list.get(list.size() - 1)) {
                list.add(map.get(num));
                continue;
            }
            int left = 0, right = list.size() - 1;
            while (left < right) {
                int pivot = (left + right) >>> 1;
                if (list.get(pivot) < map.get(num))
                    left = pivot + 1;
                else
                    right = pivot;
            }
            list.set(left, map.get(num));
        }
        return target.length - list.size();
    }
}