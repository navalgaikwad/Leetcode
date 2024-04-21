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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = head;//take current
        ListNode prev = dummy;//prev
        int i =1;
        while(current != null && i < left) {
            prev = current;
            current = current.next;
            i++;
        }
        ListNode prevStart = prev;
        ListNode start = current;
        while(current!=null && i<= right) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            i++;
        }
        start.next = current;
        prevStart.next = prev;
        return dummy.next;
    }
}