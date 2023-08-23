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
        ListNode root = head;
        while (head != null) {
            int m1 = m, n1 = n;
            while (head != null && m1 > 1) {
                head = head.next;
                m1 -= 1;
            }
            ListNode dummy = head;
            while (head != null && n1 >= 0) {
                head = head.next;
                n1 -= 1;
            }
            if (dummy != null) 
                dummy.next = head;
        }
        return root;
    }
}