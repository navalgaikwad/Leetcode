class Solution {
public ListNode removeNthFromEnd(ListNode head, int n) {
// Step 1: Find the length of the list
ListNode current = head;
int len = 0;
while (current != null) {
current = current.next;
len++;
}
// Step 2: If n is equal to the length, remove the head
if (n == len) {
return head.next;
}
// Step 3: Find the node just before the one to remove
current = head;
for (int i = 1; i < len - n; i++) {
current = current.next;
}
// Step 4: Remove the nth node from the end
current.next = current.next.next;
return head;
}
}
​