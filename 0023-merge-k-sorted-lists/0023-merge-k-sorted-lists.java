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
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b)->a.val - b.val);
        for(int i =0 ;i<lists.length; i++) {
            ListNode node = lists[i];
            if(node!=null) pq.add(node);

        }
        
       ListNode root = new ListNode(-1);
        ListNode dummy = root;
        while(!pq.isEmpty()) {
            ListNode node = pq.remove();
            dummy.next = node;
            dummy = dummy.next;
                        
            if(node.next!=null) {
                pq.add(node.next);
            }
        }
        
        return root.next;
    }
}