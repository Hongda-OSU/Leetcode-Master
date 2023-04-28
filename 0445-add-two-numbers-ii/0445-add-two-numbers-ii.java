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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int n1 = 0, n2 = 0;
        ListNode curr1 = l1, curr2 = l2;
        while (curr1 != null) {
            curr1 = curr1.next;
            n1++;
        }
        while (curr2 != null) {
            curr2 = curr2.next;
            n2++;
        }
        curr1 = l1;
        curr2 = l2;
        ListNode head = null;
        while (n1 > 0 && n2 > 0) {
            int val = 0;
            if (n1 >= n2) {
                val += curr1.val;
                curr1 = curr1.next;
                n1--;
            }
            if (n1 < n2) {
                val += curr2.val;
                curr2 = curr2.next;
                n2--;
            }
            ListNode curr = new ListNode(val);
            curr.next = head;
            head = curr;
        }
        curr1 = head;
        head = null;
        int carry = 0;
        while (curr1 != null) {
            int val = (curr1.val + carry) % 10;
            carry = (curr1.val + carry) / 10;
            ListNode curr = new ListNode(val);
            curr.next = head;
            head = curr;
            curr1 = curr1.next;
        }
        if (carry != 0) {
            ListNode curr = new ListNode(carry);
            curr.next = head;
            head = curr;
        }
        return head;
    }
}