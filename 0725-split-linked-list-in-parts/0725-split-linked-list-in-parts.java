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
    public ListNode[] splitListToParts(ListNode head, int k) {
        
        ListNode[] node = new ListNode[k];
        int len = 0;
        ListNode current = head;
        while(current!=null) {
            current = current.next;
            len++;
        }
        int partition = len / k;
        int remainder = len % k;
        current = head;
        int index =0;
        for (int i = 0; i < k; i++) {
            if(current == null) {
                node[i] = null;
            }else {
                node[i] = current;
                int value = partition + (remainder-->0 ? 1 : 0);
               
                for(int j=1; j<value; j++) {
                   if (current != null) current = current.next;
                }
                if (current != null) {
                    ListNode next = current.next;
                    current.next = null;
                    current = next;
                }
            }
        }
        return node;
    }
}