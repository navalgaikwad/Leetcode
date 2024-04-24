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
     public ListNode removeNthFromEnd(ListNode head, int n) {
         //[1,2,3,4,5] n=5
         //         c
        ListNode current = head;//5
         for(int i=0; i < n; i++) {
             current = current.next;
         }
         ListNode slow = head;//1
         ListNode fast = current;//5
         ListNode previous = null;//1
         while(fast != null) {
             previous = slow;
             slow = slow.next;
             fast = fast.next;
         }
         if(previous == null) {
             return head.next;
         }
         previous.next = slow.next;
         return head;
    }
}