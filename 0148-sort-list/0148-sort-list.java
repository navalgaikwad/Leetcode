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
    
    private ListNode sort(ListNode head){
        if(head == null || head.next == null){
             return  head;
        }
         
     ListNode mid = middle(head);
     ListNode next = mid.next;
     mid.next = null;
     ListNode  left = sort(head);
     ListNode  right = sort(next);
         
     return mergeLinkList(left, right);
    }
    
    private ListNode mergeLinkList(ListNode left, ListNode right){
        ListNode temp = new ListNode(0);
        ListNode dm = temp;
        
        while(left!= null && right!=null){
           if(left.val < right.val){
                dm.next = left;
                left = left.next;
            }else{
                dm.next = right;
                right = right.next; 
            }
            dm = dm.next;
        }
    
        dm.next = (left == null) ? right : left;  
        return temp.next;
    }
    
    private ListNode middle(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        
        while(fast !=null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // if(prev != null){
        //     prev.next = null;
        // }
        return prev;
    }
}