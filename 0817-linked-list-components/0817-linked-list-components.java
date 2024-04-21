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
    public int numComponents(ListNode head, int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(Integer num : nums) {
            set.add(num);
        }
        //ListNode curr = head;
        int count = 0;
        while(head != null) {
            ListNode curr = head;
            boolean found = false;
            
            while(curr!=null && set.contains(curr.val)) {
                found = true;
                curr = curr.next;
            }
            if(found) {
                count++;
            }
            head = curr == null ? null : curr.next;
        }
        
        return count;
    }
}