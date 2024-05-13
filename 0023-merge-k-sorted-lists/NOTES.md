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
public ListNode mergeKLists(ListNode[] lists) {
if(lists.length == 0) return null;
PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b)->(a.val - b.val));
for(ListNode list : lists) {
if(list != null) pq.add(list);
}
ListNode cnt = new ListNode(0);
ListNode dummy = cnt;
while(!pq.isEmpty()) {
ListNode current = pq.remove();
dummy.next = current;
dummy = dummy.next;
if(current.next != null) {
pq.add(current.next);
}
}
return cnt.next;
}
}