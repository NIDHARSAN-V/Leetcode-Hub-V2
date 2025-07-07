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
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] res = new int[m][n];
        int r = 0;
        int c = 0;

        
        int bottom = m - 1;
        int right = n - 1;

        
        for (int i = 0; i < m; i++) {
            Arrays.fill(res[i], -1);
        }

        while (r <= bottom && c <= right && head != null) {
            // left to right
            for (int i = c; i <= right && head != null; i++) {
                res[r][i] = head.val;
                head = head.next;
            }
            r++;

            // top to bottom
            for (int i = r; i <= bottom && head != null; i++) {
                res[i][right] = head.val;
                head = head.next;
            }
            right--;

            // right to left
            if (r <= bottom) {
                for (int i = right; i >= c && head != null; i--) {
                    res[bottom][i] = head.val;
                    head = head.next;
                }
                bottom--;
            }

            // bottom to top
            if (c <= right) {
                for (int i = bottom; i >= r && head != null; i--) {
                    res[i][c] = head.val;
                    head = head.next;
                }
                c++;
            }
        }

        return res;
    }
}
