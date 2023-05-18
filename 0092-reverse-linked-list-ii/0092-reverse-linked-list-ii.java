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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null)
            return null;
        ListNode curr = head, prev = null;
        while (left > 1) {
            prev = curr;
            curr = curr.next;
            left--;
            right--;
        }
        ListNode dummy = prev, tail = curr;
        ListNode third = null;
        while (right > 0) {
            third = curr.next;
            curr.next = prev;
            prev = curr;
            curr = third;
            right--;
        }
        if (dummy != null)
            dummy.next = prev;
        else
            head = prev;
        tail.next = curr;
        return head;
    }
}