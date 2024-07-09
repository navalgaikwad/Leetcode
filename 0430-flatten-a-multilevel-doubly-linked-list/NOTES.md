class Solution {
public Node flatten(Node head) {
if(head == null) {
return head;
}
Node current = head;
while(current != null) {
//if no child
if(current.child == null) {
current = current.next;
continue;
}
Node temp = current.child;
while(temp.next != null) {
temp = temp.next;
}
temp.next = current.next;
if(current.next!=null) {
current.next.prev = temp;
}
current.next = current.child;
current.next.prev = current;
current.child = null;
}
return head;
}
}