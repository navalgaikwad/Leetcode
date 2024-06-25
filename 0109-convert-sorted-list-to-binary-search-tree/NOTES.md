class Solution {
public TreeNode sortedListToBST(ListNode head) {
if (head == null) {
return null;
}
return toBst(head, null);
}
​
private TreeNode toBst(ListNode head, ListNode tail) {
if (head == tail) {
return null;
}
​
ListNode slow = head, fast = head;
while (fast != tail && fast.next != tail) {
slow = slow.next;
fast = fast.next.next;
}
TreeNode root = new TreeNode(slow.val);
root.left = toBst(head, slow);
root.right = toBst(slow.next, tail);
return root;
}