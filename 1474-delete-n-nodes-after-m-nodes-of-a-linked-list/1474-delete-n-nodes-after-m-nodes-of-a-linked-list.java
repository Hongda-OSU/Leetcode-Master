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
class Solution {
    public ListNode deleteNodes(ListNode head, int m, int n) {
        ListNode curr = head;
        ListNode lastM = head;     
        while (curr != null) {
            int mCount = m, nCount = n;
            while (curr != null && mCount != 0) {
                lastM = curr;
                curr = curr.next;
                mCount--;
            }
            while (curr != null && nCount != 0) {
                curr = curr.next;
                nCount--;
            }
            lastM.next = curr;
        }
        return head;
    }
}