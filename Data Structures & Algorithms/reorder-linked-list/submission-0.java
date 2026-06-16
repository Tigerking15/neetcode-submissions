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
    public void reorderList(ListNode head) 
    {
        if(head==null || head.next==null)
        {
            return;
        }
        
        ListNode first=head;
        ListNode middle = findMiddle(head);
        ListNode newHead = middle.next;
        middle.next=null;

        ListNode reversedHead = reverseLL(newHead);

        while(reversedHead!=null)
        {
            ListNode temp1 = first.next;
            ListNode temp2 = reversedHead.next;

            first.next = reversedHead;
            reversedHead.next = temp1;

            first = temp1;
            reversedHead = temp2;
        }


    }

    public ListNode findMiddle(ListNode head)
    {
        ListNode slow=head;
        ListNode fast= head;


        while(fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }

    public ListNode reverseLL(ListNode head) 
    {
        ListNode prev = null;
        ListNode temp = head;

        while(temp!=null)
        {
            ListNode front =temp.next;
            temp.next=prev;
            prev=temp;
            temp=front;
        }
        return prev;
    }
}
