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
    public int[] nextLargerNodes(ListNode head) {
        Stack<Integer> mainStack = new Stack<>();
        while(head!=null) {
            mainStack.push(head.val);
            head = head.next;
        }
        int[] res = new int[mainStack.size()];
        Stack<Integer> largerNodeStack = new Stack<>();
        int j =0;
        for(int i = mainStack.size() - 1; i>=0; i--) {
            while(!largerNodeStack.isEmpty() && mainStack.peek() >= largerNodeStack.peek()) {
                largerNodeStack.pop();
            }
            if(!largerNodeStack.isEmpty()) {
                res[i] = largerNodeStack.peek();
            }
            largerNodeStack.push(mainStack.pop());
        }
        return res;
    }
}