class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        
        // Add the head of each list to the priority queue
        for (ListNode list : lists) {
            if (list != null) {
                pq.add(list);
            }
        }
        
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        
        // Process the priority queue
        while (!pq.isEmpty()) {
            ListNode node = pq.remove();
            current.next = node;
            current = current.next;
            
            // If there are more nodes in the current list, add the next one
            if (node.next != null) {
                pq.add(node.next);
            }
        }
        
        return dummy.next;
    }
}
