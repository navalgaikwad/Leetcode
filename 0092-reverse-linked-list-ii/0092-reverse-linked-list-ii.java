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
    public ListNode  reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = head;
        ListNode prev = dummy;
        int i=1;
        
         while(current != null && i < left) {
            prev = current;
            current = current.next;
            i++;
        }
        ListNode currentHead = current;//2
        //System.out.print(prev.val);
        ListNode prevStart = prev;//1
        //ListNode nextNode = current;
        //reverse logiv
        while(current!=null && i <= right) {
            ListNode next= current.next;
            current.next = prev;
            prev = current;
            current = next;
            i++;
        }
        currentHead.next = current; //2->5
        prevStart.next = prev;//1->4
        return dummy.next;
    }
}