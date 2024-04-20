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
    public ListNode mergeNodes(ListNode head) {
        int sum = 0;
        ListNode dummy = head;
        //dummy = head;
        ListNode current = head;
        while(current!=null) {
            
            if(current.val == 0 && sum!=0) {
                ListNode node = new ListNode(sum);
                sum =0;
                dummy.next = node;
                dummy = dummy.next;
            }
            sum+=current.val;
            current = current.next;
        }
        return head.next;
    }
}