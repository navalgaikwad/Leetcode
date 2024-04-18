/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode list1 = headA;
        ListNode list2 = headB;
        
        int count1 =0;
        int count2 =0;
        while(list1 != null) {
            count1++;
            list1 = list1.next;
        }
        while(list2 != null) {
            count2++;
            list2 = list2.next;
        }
        list1= headA;
        list2 = headB;
        if(count1 > count2) {
            for(int i =0; i< count1 - count2; i++) {
                list1 = list1.next;
            }
        }else if(count1 < count2) {
            for(int i =0; i< count2 - count1; i++) {
                list2 = list2.next;
            }
        }
        while(list1!=null && list2!=null) {
            if(list1 == list2) {
                return list1;
            }
            list1 = list1.next;
            list2 = list2.next;
        }
        return null;
    }
}