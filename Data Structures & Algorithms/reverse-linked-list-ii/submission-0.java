class Solution {

    public ListNode reverseLL(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }

        return prev;
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {

        if (head == null || left == right)
            return head;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode prev = dummy;

        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }

        ListNode start = prev.next;
        ListNode end = start;


        for (int i = left; i < right; i++) {
            end = end.next;
        }


        ListNode newHead = end.next;
        end.next = null;

        ListNode reversedHead = reverseLL(start);

        prev.next = reversedHead;
        start.next = newHead;

        return dummy.next;
    }
}