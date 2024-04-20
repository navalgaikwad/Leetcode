/**
* Definition for singly-linked list.
* public class ListNode {
*     int val;
*     ListNode next;
*     ListNode() {}
*     ListNode(int val) { this.val = val; }
*     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
* }
*/
class Solution {
public ListNode swapPairs(ListNode head) {
ListNode dummy = new ListNode(0);
dummy.next = head;
ListNode curr = dummy;
while(curr.next != null && curr.next.next!=null) {
ListNode first = curr.next;
ListNode second = curr.next.next;
first.next = second.next;
curr.next = second;
curr.next.next = first;
curr = curr.next.next;
}
return dummy.next;
}
}