/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 **/
// https://leetcode.com/problems/reverse-nodes-in-k-group/
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
         if (head == null) {return head;}

         // reach to kth node
         ListNode temp = head;
         int i = 0;
         while(i<k-1 && temp != null) {
            temp = temp.next;
            i++;
         }

         if (temp == null) {
            return head;
         }

         ListNode rem = temp.next;
         temp.next = null;

         // reverse this LL
         ListNode tail = head;
         head = reverseLL(head);
         tail.next = reverseKGroup(rem, k);


        return head;
    }
    
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {return head;}

        // atleast 2 nodes
        ListNode rem = head.next.next;

        ListNode newHead = head.next;
        newHead.next = head;
        
        newHead.next.next = swapPairs(rem);

        return newHead;

    }

    public ListNode reverseLL(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode tail = head.next;

        ListNode newHead = reverseLL(head.next);
        tail.next = head;
        head.next = null;
        return newHead;
    }
}
