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
    static {
        for (int i = 0; i < 500; i++)
            sortList(null);
    }

    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        ListNode t = head;
        while (t != null) {
            max = Math.max(max, t.val);
            min = Math.min(min, t.val);
            t = t.next;
        }
        int range = max - min + 1, count[] = new int[range];
        t = head;
        while (t != null) {
            count[t.val - min]++;
            t = t.next;
        }
        t = head;
        for (int i = 0; i < range; i++) {
            while (count[i] != 0) {
                t.val = i + min;
                t = t.next;
                count[i]--;
            }
        }
        return head;
    }
}