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
    public ListNode insertionSortList(ListNode head) {
        // Dummy node for sorted list
        ListNode dummy = new ListNode(0);
        
        ListNode curr = head;
        
        while (curr != null) {
            ListNode next = curr.next; // store next node
            
            // Find position to insert
            ListNode prev = dummy;
            while (prev.next != null && prev.next.val < curr.val) {
                prev = prev.next;
            }
            
            // Insert current node
            curr.next = prev.next;
            prev.next = curr;
            
            // Move to next node
            curr = next;
        }
        
        return dummy.next;
    }
}