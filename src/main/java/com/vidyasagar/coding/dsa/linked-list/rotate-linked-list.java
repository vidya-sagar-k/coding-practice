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
  // https://leetcode.com/problems/rotate-list/
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0){
            return head;
        }

        // atleast 2 nodes
        // skip calculating length first and doing k = k%n;

        ListNode f = head;
        ListNode s = head;
        int i = 0;
        
        while(i<k && f.next != null){
            f=f.next;
            i++;
        }
        if (f.next == null && i<k) {
            // k == length
            if (i == k-1) return head;
            else {
                int n = i+1;
                // k>n
                k = k%n;
                return rotateRight(head, k);
            }
        }

        while (f.next != null) {
            f = f.next;
            s = s.next;
        }

        f.next = head;
        head = s.next;
        s.next = null;

        return head;
    }
}
