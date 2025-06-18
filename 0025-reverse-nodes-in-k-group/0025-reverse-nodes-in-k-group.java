class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0, head);
        ListNode gprev = dummy;

        while (true) {
            ListNode gnext = func(gprev, k);
            if (gnext == null) break;

            ListNode curr = gprev.next;
            ListNode prev = gnext.next;

            ListNode start = curr; 

          
            for (int i = 0; i < k; i++) {
                ListNode tmp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = tmp;
            }

           
            gprev.next = prev;

            
            gprev = start;
        }

        return dummy.next;
    }

    private ListNode func(ListNode gprev, int k) {
        while (gprev != null && k > 0) {
            gprev = gprev.next;
            k--;
        }
        return gprev;
    }
}
