}
​
return true;
}
​
ListNode middle(ListNode head) {
ListNode slow = head;
ListNode fast = head;
ListNode prev = null;
​
while (fast != null && fast.next != null) {
prev = slow;
slow = slow.next;
fast = fast.next.next;
}
​
if (fast != null) {
slow = slow.next;
}
​
return slow;
}
​
void reverse(ListNode head) {
ListNode temp = head;
ListNode prev = null;
​
while (temp != null) {
ListNode nextPointer = temp.next;
temp.next = prev;
prev = temp;
temp = nextPointer;
}
}
}