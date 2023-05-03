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
        HashMap<Integer, Integer> repeatedNodes = new HashMap<>();
        ListNode tempHead = new ListNode(); // temporary node as a temp head in case the head is one of the nodes needs to be deleted or head is null
        tempHead.next = head; // set temporary node next to head
        ListNode curr = tempHead.next;
        while(curr!=null) {
            repeatedNodes.put(curr.val, repeatedNodes.getOrDefault(curr.val, 0)+1); // count the repeated node values
            curr=curr.next;
        }

        ListNode prev = tempHead; // set the previous node (parent node) to temporary head
        curr = tempHead.next;
        while(curr !=null) {
            if(repeatedNodes.get(curr.val)>1) { // if current node value is bigger than 1, it needs to be deleted
                prev.next = curr.next; // set previous node next to curr.next instead of curr. As curr node needs to be deleted
                curr.next = null; // set curr next to null as we need to remove curr from the list, so need to set it's pointer to null
                curr = prev; // make sure we set current node to previous node as current node has been already removed from the list
            }
            prev=curr;
            curr = curr.next;
        }

        return tempHead.next; // we should return tempHead.next but not tempHead as tempHead is a dummy node we created
    }
}