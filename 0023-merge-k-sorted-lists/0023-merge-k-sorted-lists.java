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
        if(lists.length == 0) return null; 
        PriorityQueue<ListNode> pq= new PriorityQueue<>((a,b)-> a.val-b.val);
        for(ListNode list : lists) {
            if(list != null) pq.add(list);
        }
        //System.out.print(pq);
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while(!pq.isEmpty()) {
            ListNode list = pq.remove();
            curr.next = list;
            curr = curr.next;
            if(list.next!= null) {
                pq.add(list.next);
            }
        }
        return dummy.next;
    }
}