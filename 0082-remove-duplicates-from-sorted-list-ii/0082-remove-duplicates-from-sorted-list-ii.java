/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode temp = new ListNode(0);
        temp.next = head;
        ListNode prev = temp;//non duplifate
        ListNode curr = head;
        while(curr != null) {
            while(curr.next!=null && curr.val == curr.next.val) {
                curr = curr.next;
            }
            if(prev.next == curr) {
                prev = prev.next;
            } else {
                prev.next = curr.next;//it should saty one behind
            }
            curr = curr.next;
        }
        return temp.next;
    }
}