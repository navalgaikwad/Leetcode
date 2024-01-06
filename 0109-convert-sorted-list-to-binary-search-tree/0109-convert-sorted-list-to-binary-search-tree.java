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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while(head!=null) {
            list.add(head.val);
            head = head.next;
        }
        return buildTree(list, 0, list.size()-1);
    }
    
    TreeNode buildTree(List<Integer> list, int low, int high) {
        if(low > high) {
            return null;
        }
        
        int mid = low + (high - low)/2;
        TreeNode root = new TreeNode(list.get(mid));
        root.left = buildTree(list, low, mid - 1);
        root.right = buildTree(list, mid + 1, high);
        
        return root;
    }
    
    
}