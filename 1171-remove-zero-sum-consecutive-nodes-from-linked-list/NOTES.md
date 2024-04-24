class Solution {
public ListNode removeZeroSumSublists(ListNode head) {
ListNode front = new ListNode(0, head);
ListNode start = front; //0
while(start != null) {
ListNode end = start.next;//1
int prefix = 0;
while(end != null){
prefix+=end.val;
if(prefix == 0) {
start.next = end.next;
}
end = end.next;
}
start = start.next;
}
return front.next;
}
}