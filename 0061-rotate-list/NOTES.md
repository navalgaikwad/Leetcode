class Solution {
public ListNode rotateRight(ListNode head, int k) {
if(head==null || k==0) return head;
ListNode temp = head;
int len = 1;
while(temp.next != null) {
len++;
temp = temp.next;
}
temp.next = head;//created cycle
int jump=len-k%len;
temp = head;
while(jump >1) {
temp = temp.next;
jump--;
}
head = temp.next;//4 head
temp.next = null;//5
return head;
}
}