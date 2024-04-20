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
public int numComponents(ListNode head, int[] G) {
Set<Integer> set = new HashSet<>();
for (int i : G) {
set.add(i);
}
int count = 0;
while (head != null) {
ListNode cur = head;
boolean found = false;
while (cur != null && set.contains(cur.val)) {
found = true;
cur = cur.next;
}
if (found) {
count++;
}
head = cur == null ? cur : cur.next;
}
return count;
}
}