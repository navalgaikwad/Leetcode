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
public ListNode oddEvenList(ListNode head) {
if(head == null) {
return null;
}
// ListNode dummy = new ListNode(0);
// dummy.next = head;
ListNode odd = head;//1
ListNode even = head.next;//2
ListNode evenHead = even;
while(even != null && even.next != null) {
odd.next = odd.next.next;
even.next = even.next.next;
odd = odd.next;
even = even.next;
}
odd.next = evenHead;
return head;
}
}