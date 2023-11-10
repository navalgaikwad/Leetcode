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
    public ListNode reverseList(ListNode head) {
        if(head == null){
            return null;
        }
        if(head.next == null){
            return head; //new head
        }
        ListNode nextNode = head.next;
        head.next = null;
        ListNode newHead = reverseList(nextNode);
        nextNode.next = head;
        return newHead;
    }
}