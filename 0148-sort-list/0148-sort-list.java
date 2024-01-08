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
        return sort(head);
        
    }
    
    ListNode sort(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode middle = middle(head);
        ListNode nextNodeOfMiddle = middle.next;
        middle.next = null;
        ListNode left = sort(head);
        ListNode right = sort(nextNodeOfMiddle);
        
        return mergerList(left, right);
    }
    
    ListNode middle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        while(fast!=null && fast.next!=null) {
            prev = slow;
            slow= slow.next;
            fast = fast.next.next;
        }
        return prev;
    }
    
    ListNode mergerList(ListNode low, ListNode high) {
        ListNode root = new ListNode(-1);
        ListNode tmp = root;
        while(low != null && high != null) {
            if(low.val < high.val) {
                tmp.next = low;
                low = low.next;
            }else {
                tmp.next = high;
                high = high.next;
            }
            tmp= tmp.next;
        }
        tmp.next = (low == null) ? high : low;
        return root.next;
    }
}