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
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) {//vimp
            return head;
        }
        ListNode dummy = head;
        
        ListNode temp = middle(dummy);
        ListNode next = temp.next;
        temp.next = null;
        
        ListNode left= sortList(head);//start
        ListNode right= sortList(next);//middle
        
        return merge(left, right);//merge
    }
    
    ListNode middle(ListNode node) {
        ListNode slow = node;
        ListNode fast = node;
        ListNode prev = null;
        while(fast!=null && fast.next!=null) {
            prev = slow;
            slow= slow.next;
            fast = fast.next.next;
        }
        return prev;
    }
    
    ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        while(left != null && right != null) {
            if(left.val < right.val) {
                temp.next = left;
                left = left.next;
            }else {
                temp.next = right;
                right = right.next;
            }
            temp = temp.next;
        }
        temp.next = left == null ? right :left; 
        return dummy.next;
    }
}