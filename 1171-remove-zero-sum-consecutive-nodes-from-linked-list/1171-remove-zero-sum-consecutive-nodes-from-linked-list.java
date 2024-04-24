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
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode current = new ListNode(0, head);
        ListNode start = current;
        
        while(start != null) {
            ListNode end = start.next;
            int sum =0;
             while(end != null){
                
                sum+=end.val;
                if(sum == 0) {
                    start.next = end.next;
                }
                end = end.next;
            }
            start = start.next;
        }
        return current.next;
    }
}