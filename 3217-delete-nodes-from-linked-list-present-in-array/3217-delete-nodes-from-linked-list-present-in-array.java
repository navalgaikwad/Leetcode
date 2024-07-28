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
    public ListNode modifiedList(int[] nums, ListNode head) {
        if(head == null) {
            return null;
        }
        Set<Integer> set = new HashSet<>();
        for(int num : nums) {
            set.add(num);
        }
        return helper(set, head);
    }
    
    ListNode helper(Set<Integer> nums, ListNode head) {
        if(head == null) {
            return null;
        }
        head.next = helper(nums, head.next);
        if(head != null) {
            if(nums.contains(head.val)) {
                head = head.next;
            }
        }
        return head;
    }
}

 //nums = [1,2,3], head = [1,2,3,4,5]
/*


*/