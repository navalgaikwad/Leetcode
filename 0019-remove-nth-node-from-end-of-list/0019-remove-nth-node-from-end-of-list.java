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
        int len =0;
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode firstNode = head;
        while(firstNode != null) {
            firstNode = firstNode.next;
            len++;
        }
        len = len - n; //5-5 =0 
        firstNode = dummy;
        while( len > 0) {
            firstNode = firstNode.next;
            len--;
        } 
        
        firstNode.next = firstNode.next.next;
        return dummy.next;
        
    }
}
//find length of the linkedList
//n%len = len
//go on 3  next = node.next.next;
// 3 to 5
// O(n)