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
    public ListNode swapPairs(ListNode head) {
       ListNode dum = new ListNode(0 , head);
       ListNode temp = head;
       ListNode curr = dum;

       while(curr.next!=null && curr.next.next!=null)
       {
          ListNode slow = curr.next;
          ListNode fast = curr.next.next;

          slow.next = fast.next;
          fast.next = slow;

          curr.next = fast;


          curr = slow;



       } 
       return dum.next;
    }
}