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
import java.util.*;

class Solution {
    public int[] nextLargerNodes(ListNode head) {
        
        // Step 1: Convert linked list to array
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        
        int n = list.size();
        int[] res = new int[n];
        
        // Step 2: Monotonic stack (stores indices)
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && list.get(i) > list.get(stack.peek())) {
                int idx = stack.pop();
                res[idx] = list.get(i);
            }
            stack.push(i);
        }
        
        // Remaining indices will have 0 (default)
        return res;
    }
}