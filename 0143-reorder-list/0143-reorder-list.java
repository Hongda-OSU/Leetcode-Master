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
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        //Find the middle of the list
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //Reverse the half after middle  1->2->3->4->5->6 to 1->2->3->6->5->4
        ListNode mid = slow, curr = slow.next;
        while (curr.next != null) {
            ListNode temp = curr.next;
            curr.next = temp.next;
            temp.next = mid.next;
            mid.next = temp;
        }
        //Start reorder one by one  1->2->3->6->5->4 to 1->6->2->5->3->4
        ListNode p1 = head, p2 = mid.next;
        while (p1 != mid) {
            mid.next = p2.next;
            p2.next = p1.next;
            p1.next = p2;
            p1 = p2.next;
            p2 = mid.next;
        }
    }
}