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
        int length = 0;
        ListNode current = head;


        while (current != null) {
            current = current.next;
            length++;
        }


        int partition = length / k;
        int remainder = length % k;

        ListNode[] result = new ListNode[k];
        current = head;

        for (int i = 0; i < k; i++) {
            if (current == null) {
                result[i] = null; 
            } else {
                result[i] = current; 
                int currentPartitionSize = partition + (remainder-- > 0 ? 1 : 0);


                for (int j = 1; j < currentPartitionSize; j++) {
                    if (current != null) current = current.next;
                }


                if (current != null) {
                    ListNode next = current.next;
                    current.next = null;
                    current = next;
                }
            }
        }

        return result;
    }


}