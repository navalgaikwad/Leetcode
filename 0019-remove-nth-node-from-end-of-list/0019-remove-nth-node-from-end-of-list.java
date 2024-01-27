class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n <= 0) {
            return head; // Invalid input
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        int len = 0;
        ListNode current = head;
        while (current != null) {
            len = len + 1;
            current = current.next;
        }

        if (n > len) {
            return head; // Invalid input, n is greater than the length of the list
        }

        current = dummy;
        for (int i = 0; i < len - n; i++) {
            current = current.next;
        }

        current.next = current.next.next;

        return dummy.next;
    }
}
