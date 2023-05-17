class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums.length == 0)
            return result;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            sb.setLength(0);
            while (i + 1 < nums.length && nums[i + 1] - nums[i] == 1)
                i++;
            if (curr != nums[i]) {
                sb.append(curr);
                sb.append("->");
                sb.append(nums[i]);
            } else {
                sb.append(curr);
            }
            result.add(sb.toString());
        }
        return result;
    }
}