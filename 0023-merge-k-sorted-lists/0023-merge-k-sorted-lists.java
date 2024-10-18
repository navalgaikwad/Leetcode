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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq =new PriorityQueue<>((a,b)->a.val - b.val);
        for(ListNode list : lists) {
            if(list!=null) {
                pq.add(list);
            }
        }
        
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        while(!pq.isEmpty()) {
            ListNode node = pq.remove();
            current.next = node;
            current = current.next;
            if(node.next!=null) {
                pq.add(node.next);
            }
        }
        return dummy.next;
        
    }
}