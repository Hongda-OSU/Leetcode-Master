/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private static int[] pattern, lps;
    
    public boolean isSubPath(ListNode head, TreeNode root) {
        pattern =  convertLinkedListToArray(head);
        lps = computeKMPTable(pattern);
        return kmpSearch(root, 0);
    }
    
    private int[] convertLinkedListToArray(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++)
            arr[i] = list.get(i);
        return arr;
    }
    
    private int[] computeKMPTable(int[] pattern) {
        int n = pattern.length;
        int[] lps = new int[n];
        for (int i = 1, j = 0; i < n; i++) {
            while (j > 0 && pattern[i] != pattern[j])
                j = lps[j - 1];
            if (pattern[i] == pattern[j])
                lps[i] = ++j;
        }
        return lps;
    }
    
    private boolean kmpSearch(TreeNode node, int position) {
        if (position == pattern.length)
            return true;
        if (node == null)
            return false;
        while (position > 0 && node.val != pattern[position])
            position = lps[position - 1];
        if (node.val == pattern[position])
            position++;
        return kmpSearch(node.left, position) || kmpSearch(node.right, position);
    }
} 