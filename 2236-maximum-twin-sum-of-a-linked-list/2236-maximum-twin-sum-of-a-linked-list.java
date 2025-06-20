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

    private ListNode reverse(ListNode head)
    {
        ListNode prev = null;
        ListNode nxt = null;
        while(head!=null)
        {
            nxt = head.next;
            head.next = prev;
            prev = head;
            head = nxt;
        }

        return prev;

    }
    
    public int pairSum(ListNode head) {
        
        if(head.next.next==null)
        {
            return head.val + head.next.val;
        }


        ListNode slow = head;
        ListNode fast = head.next;

        while(fast!=null && fast.next!=null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode rev = reverse(slow.next);
        ListNode nor = head;
        int pairsum = 0;


        while(rev!=null && nor!=null)
        {
            pairsum = Math.max(pairsum , rev.val + nor.val);
            rev = rev.next;
            nor = nor.next;
        }

        return pairsum;


    }
}