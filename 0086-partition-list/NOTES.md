class Solution {
public ListNode partition(ListNode head, int x) {
ListNode dummy = new ListNode(-1);
dummy.next = head;
ListNode prev = dummy;
ListNode curr = head;
ListNode partition = dummy;
while(curr != null) {
if(curr.val < x) {
if(partition.next == curr) {
partition = partition.next;
prev = curr;
curr = curr.next;
continue;
}
ListNode temp = curr;
curr = curr.next;
prev.next = curr;
temp.next = partition.next;
partition.next = temp;
partition = partition.next;
continue;
}
prev = curr;
curr = curr.next;
}
return dummy.next;
}
}