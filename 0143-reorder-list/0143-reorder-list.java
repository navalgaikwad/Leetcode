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
    public void reorderList(ListNode head) {
        if(head == null) {
            return;
        }
        ListNode middle = middle(head);
        ListNode second = reverse(middle);
        
        ListNode first = head;
        ListNode tmp;
        while(second.next != null) {
            tmp = first.next;//2
            first.next = second;
            first = tmp;//2,3,4
            
            tmp = second.next;
            second.next = first;
            second = tmp;
            
        }
    }
    
    ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while(current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
    
    ListNode middle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}