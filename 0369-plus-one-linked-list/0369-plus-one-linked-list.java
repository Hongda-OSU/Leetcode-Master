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
    public ListNode plusOne(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode special = dummy;
        while (head != null) {
            if (head.val != 9)
                special = head;
            head = head.next;
        }
        special.val++;
        special = special.next;
        while (special != null) {
            special.val = 0;
            special = special.next;
        }
        return dummy.val != 0 ? dummy : dummy.next;
    }
}