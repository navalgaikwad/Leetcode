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
    public ListNode removeNthFromEnd(ListNode head, int n) {
       ListNode dummy = new ListNode(0);
       dummy.next = head;

    // Step 1: Move `firstNode` n+1 steps ahead to maintain the gap with `secondNode`.
        ListNode firstNode = dummy;
        for (int i = 0; i <= n; i++) {
            if (firstNode == null) return head; // Edge case: n is greater than the length of the list
            firstNode = firstNode.next;
        }

    // Step 2: Move `firstNode` to the end, maintaining the gap with `secondNode`.
    ListNode secondNode = dummy;
    while (firstNode != null) {
        firstNode = firstNode.next;
        secondNode = secondNode.next;
    }

    // Step 3: Remove the nth node from the end
    secondNode.next = secondNode.next.next;

    return dummy.next;
    }
}