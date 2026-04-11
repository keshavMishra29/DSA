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
        
        l1 = reverse(l1);
        l2 = reverse(l2);

        int carry = 0;

        ListNode curr = new ListNode(-1);
        ListNode dummy = curr;

        while(l1!=null|| l2!=null || carry!=0){
            int d1 = l1!=null ? l1.val : 0;
            int d2 = l2!=null ? l2.val : 0;

            int sum = d1 + d2 + carry;

            curr.next = new ListNode(sum % 10);
            carry = sum / 10;

            if(l1!=null) l1 = l1.next;
            if(l2!=null) l2 = l2.next;

            curr = curr.next;

        }
        
        ListNode nh = dummy.next;
        dummy.next = null;
        return reverse(nh);

    }

    ListNode reverse(ListNode head){

        ListNode prev = null;

        while(head!=null){
            ListNode forw = head.next;
            head.next = prev;
            prev = head;
            head = forw;
        }

        return prev;
    }


}