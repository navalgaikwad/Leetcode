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
        ListNode dummy = root;
        int carry =0;
        while(l1!=null || l2!=null || carry!=0) {
            int val1 =0;
            int val2 =0;
            if(l1!=null) {
                val1 = l1.val;
                l1 = l1.next;
            }
            if(l2!=null) {
                val2 = l2.val;
                l2 = l2.next;
            }
            int sum = val1+val2 + carry;
            int val = sum %10;
            carry = sum/10;
            ListNode curr = new ListNode(val);
            dummy.next = curr;
            dummy = dummy.next;
        }
        return root.next;
    }
}