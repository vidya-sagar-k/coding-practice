//https://leetcode.com/problems/add-two-numbers-ii/
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
    private ListNode reverseLL(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode rem = head.next;
        ListNode newHead = reverseLL(rem);
        rem.next = head;
        head.next = null;
        return newHead;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        l1 = reverseLL(l1);
        l2 = reverseLL(l2);

        int sum = l1.val + l2.val;
        int c = sum/10;
        sum = sum%10;
            
        ListNode prevNode = new ListNode(sum);
        ListNode tail = prevNode;
        l1 = l1.next;
        l2 = l2.next;
        while(l1 != null || l2 != null || c > 0) {
            sum = c;
            if (l1 != null){
                sum += l1.val;
                l1 = l1.next;
            } 
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            } 
            c = sum/10;
            sum = sum%10;

            prevNode.next = new ListNode(sum);
            prevNode = prevNode.next;
        }

        return reverseLL(tail);
    }
}
