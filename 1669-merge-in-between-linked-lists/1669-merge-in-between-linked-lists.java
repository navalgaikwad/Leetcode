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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode current = list1;
        for(int i=1; i<a; i++) {
            current = current.next;
        }
       // ListNode leftSide = current;
        
        ListNode middleList = current;
        for(int i=a; i<=b; i++) {
            middleList = middleList.next;
        }
        current.next = list2;
        while(list2.next!=null) {
            list2 = list2.next;
        }
        list2.next=middleList.next;
        return list1;
    }
}