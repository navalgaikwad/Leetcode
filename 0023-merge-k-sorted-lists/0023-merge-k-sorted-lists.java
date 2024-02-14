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
        PriorityQueue<ListNode> pq= new PriorityQueue<>((a,b)->(a.val - b.val));
        for(ListNode list : lists) {
            if(list!=null) pq.add(list);
        }
       // System.out.print(pq);
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        while(!pq.isEmpty()) {
            // ListNode list = 
            // if(list != null) {
                ListNode list = pq.remove();
                current.next = list;
                current = current.next;
                if(list.next != null) {
                   pq.add(list.next); 
                }
            //}
            
        }
        
        return dummy.next;
    }
}
//[[1,4,5],[1,3,4],[2,6]]
//keep the head in priority Queue
//accordingly i will create 