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
    public ListNode deleteDuplicatesUnsorted(ListNode head) {
         Map<Integer, Integer> nodeCounts = new HashMap<>();
        for (ListNode curr = head; curr != null; curr = curr.next) {
            nodeCounts.put(curr.val, nodeCounts.getOrDefault(curr.val, 0) + 1);
        }
        // create dummy node pointing to head
        ListNode temp = new ListNode(0, head); // ListNode(int val, ListNode next)
        for (ListNode prev = temp, curr = head; curr != null; curr = curr.next) {
            if (nodeCounts.get(curr.val) == 1) { // not a duplicate
                prev = curr; // keep moving 1 step forward
            }
            else { // duplicate
                prev.next = curr.next; // skip the current node
            }
        }
        return temp.next;
    }
}