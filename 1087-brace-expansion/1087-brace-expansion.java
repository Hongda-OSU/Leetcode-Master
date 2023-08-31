class Solution {
    public String[] expand(String s) {
        List<String> list = new ArrayList<>();
        dfs(s, 0, new StringBuilder(), list);
        String[] result = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
    
    private void dfs(String str, int index, StringBuilder sb, List<String> list) {
        if (index == str.length()) {
            if (sb.length() > 0) {
                list.add(sb.toString());
            }
            return;
        }
        char ch = str.charAt(index);
        int position = sb.length();
        if (ch == '{') {
            List<Character> charList = new ArrayList<>();
            int endIndex = index + 1;
            while (endIndex < str.length() && str.charAt(endIndex) != '}') {
                if (Character.isLetter(str.charAt(endIndex))) {
                    charList.add(str.charAt(endIndex));
                }
                endIndex++;
            }
            Collections.sort(charList);
            for (char c : charList) {
                sb.append(c);
                dfs(str, endIndex + 1, sb, list);
                sb.setLength(position);
            }
        } else if (Character.isLetter(ch)) {
            sb.append(str.charAt(index));
            dfs(str, index + 1, sb, list);
        }
    }
}