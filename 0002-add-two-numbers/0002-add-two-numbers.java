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
        ListNode original = new ListNode(0);
        ListNode dummy = original;
        
        int carry = 0;
        while(l1!=null || l2!=null || carry != 0) {
            int sum =0;
            if(l1!=null) {
                sum = sum + l1.val;
                l1 = l1.next;
            }
            if(l2!=null) {
                sum = sum + l2.val;
                l2 = l2.next;
            }
            int total = sum + carry;
            carry = total/10;
            ListNode root = new ListNode(total%10);
            dummy.next = root;
            dummy = dummy.next;
        }
        return original.next;
    }
}