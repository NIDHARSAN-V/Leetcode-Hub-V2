class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
        
        Set<Integer> set = new HashSet<>();
        for (int n : nums) set.add(n);

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode temp = dummy;

        while (temp != null && temp.next != null) {

            if (set.contains(temp.next.val)) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }

        return dummy.next;
    }
}
