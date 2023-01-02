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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p1 = dummy, p2 = dummy;
        // p1 move n + 1
        for (int i = 0; i < n + 1; i++) {
            p1 = p1.next;
        }
        // p1 move L - n - 1, p2 move L - n - 1
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        // p2 is now 1 node ahead of nth node
        p2.next = p2.next.next;
        return dummy.next;
    }
}