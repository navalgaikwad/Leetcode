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
public ListNode mergeNodes(ListNode head) {
ListNode curr, root = new ListNode();
curr = root;
int sum = 0;
while(head!=null){
if(head.val==0 && sum!=0){
curr.next = new ListNode(sum);
curr = curr.next;
sum = 0;
}
sum+=head.val;
head = head.next;
}
return root.next;
}