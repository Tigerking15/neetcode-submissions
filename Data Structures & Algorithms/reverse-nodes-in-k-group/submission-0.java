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
    public ListNode reverseKGroup(ListNode head, int k) 
    {
         if (head == null || k <= 1)
        return head;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode prev = dummy;
        while (true)
        {
            ListNode start = prev.next;
            if (start == null)
            break;

            ListNode end=start;
            int count=1;
            while(end!=null && count<k)
            {
                end=end.next;
                count++;
            }

            if (end == null)
            break;

            ListNode newHead = end.next;
            end.next=null;

            ListNode reversedHead= reverseLL(start);
            prev.next = reversedHead;
            start.next = newHead;
            prev=start;

        }
        return dummy.next;
    }
        

public ListNode reverseLL(ListNode head) 
{
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
}
