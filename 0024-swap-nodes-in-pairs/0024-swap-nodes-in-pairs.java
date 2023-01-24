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
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        while (head != null && head.next != null) {
            ListNode first = head;
            ListNode second = head.next;
            // Swapping
            prev.next = second; // second become head in 1st
            first.next = second.next;
            second.next = first;
            // Reinitializing the head and prevNode for next swap
            prev = first;
            head = first.next; // head move to 3rd in 1st
        }
        return dummy.next;
    }
}