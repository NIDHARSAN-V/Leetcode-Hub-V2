class Solution {
    public int getDecimalValue(ListNode head) {
        int n = 0;
        while (head != null) {
            n = (n << 1) | head.val;
            head = head.next;
        }
        return n;
    }
}
