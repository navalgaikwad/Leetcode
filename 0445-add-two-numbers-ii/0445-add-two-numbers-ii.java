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
        Stack<Integer> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();
        
        while(l1!=null) {
            st1.push(l1.val);
            l1 = l1.next;
        }
        while(l2!=null) {
            st2.push(l2.val);
            l2 = l2.next;
        }
        ListNode ans= new ListNode();
        int total =0, carry = 0;
        while(!st1.isEmpty() || !st2.isEmpty()) {
            if(!st1.isEmpty()) {
                total+=st1.pop();
            }
            if(!st2.isEmpty()) {
                total+=st2.pop();
            }
             ans.val = total % 10;
            carry = total / 10;
            ListNode head= new ListNode(carry);
            head.next = ans;
            ans = head;
            total =carry;
        }
         return carry == 0 ? ans.next: ans;
    }
}