/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        postorder(root, sb);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        ArrayDeque<Integer> nums = new ArrayDeque<>();
        int n = data.length();
        for (int i = 0; i < (int)(n / 4); i++)
            nums.add(stringToInt(data.substring(4 * i, 4 * i + 4)));
        return helper(Integer.MIN_VALUE, Integer.MAX_VALUE, nums);
    }
    
    private void postorder(TreeNode root, StringBuilder sb) {
        if (root == null)
            return;
        postorder(root.left, sb);
        postorder(root.right, sb);
        sb.append(intToString(root.val));
    }
    
    private String intToString(int x) {
        char[] bytes = new char[4];
        for (int i = 3; i > -1; i--) 
            bytes[3 - i] = (char)(x >> (i * 8) & 0xff);
        return new String(bytes);
    }
    
    private int stringToInt(String str) {
        int result = 0;
        for (char ch : str.toCharArray())
            result = (result << 8) + (int)ch;
        return result;
    }
    
    private TreeNode helper(Integer low, Integer high, ArrayDeque<Integer> nums) {
        if (nums.isEmpty())
            return null;
        int val = nums.getLast();
        if (val < low || val > high)
            return null;
        nums.removeLast();
        TreeNode root = new TreeNode(val);
        root.right = helper(val, high, nums);
        root.left = helper(low, val, nums);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;