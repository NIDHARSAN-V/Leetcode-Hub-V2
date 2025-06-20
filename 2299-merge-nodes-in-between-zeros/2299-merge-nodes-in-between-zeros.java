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
    public ListNode mergeNodes(ListNode head) {
      if(head == null)
      {
        return null;
      }  
      ListNode temp = head.next;
      head = head.next;
      while(temp!=null)
      {
        ListNode end = temp;
        int sum = 0;
        while(end.val!=0)
        {
            sum+=end.val;
            end = end.next;
        }
        temp.val = sum;
        temp.next = end.next;
        temp = temp.next;
      }
    return head;
    }
    
}