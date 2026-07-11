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
        int len = 0;
        ListNode current = head;
        while(current != null) {
            len++;
            current = current.next;
        }
        int k = len - n -1;
        if( k < 0 ) return head.next;
        current = head;
        while(current != null & k >0) {
            k--;
            current = current.next;
        }
        current.next = current.next.next;
        return head;
    }
}