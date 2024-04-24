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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || k==0) return head;
        int length = 1;
        ListNode current = head;
        while(current.next != null) {
            current = current.next;
            length++;
        }
        current.next = head;
        current = head;
        int jump = length - k%length;
        while(jump > 1) {
           current = current.next;
            jump--;
        }
        head = current.next;
        current.next = null;
        //head = next;
        return head;
    }
}