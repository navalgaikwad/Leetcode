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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode root = new ListNode(0);
        ListNode dummy = root;
        while(list1!=null && list2!=null) {
            if(list1.val <= list2.val) {
                ListNode curr = new ListNode(list1.val);
                dummy.next = curr;
                dummy = dummy.next;
                list1 = list1.next;
            }else if(list2.val <= list1.val) {
                ListNode curr = new ListNode(list2.val);
                dummy.next = curr;
                dummy = dummy.next;
                list2 = list2.next;
            }
        }
        if(list1==null) {
            dummy.next = list2;
        }else if(list2 == null) {
            dummy.next = list1;
        }
        return root.next;
    }
}