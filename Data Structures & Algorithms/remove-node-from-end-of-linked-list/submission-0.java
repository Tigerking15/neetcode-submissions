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
    public ListNode removeNthFromEnd(ListNode head, int n) 
    {
        Stack<ListNode> st = new Stack<>();

        ListNode temp = head;
        while(temp!=null)
        {
            st.push(temp);
            temp=temp.next;
        }


        ListNode newhead =null;

        int count=1;

        while(!st.isEmpty())
        {
            ListNode node = st.pop();

            if(count==n)
            {
                count++;
                continue;
            }
            else 
            {
                node.next=newhead;
                newhead=node;
                count++;
            }

        }
        return newhead;
    }
}
