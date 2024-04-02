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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0);
        ListNode curr = root;
        int carry = 0;
        while(l1!=null || l2!=null || carry!=0) {
            int first = 0;
            int second = 0;
            if(l1!=null) {
                first = l1.val;
                l1 = l1.next;
            }
            if(l2 != null) {
                second = l2.val;
                l2 = l2.next;
            }
            int sum = first + second + carry;
            int val = sum%10;
            carry = sum/ 10;
            ListNode node = new ListNode(val);
            curr.next = node;
            curr = curr.next;
        }
        return root.next;
    }
}