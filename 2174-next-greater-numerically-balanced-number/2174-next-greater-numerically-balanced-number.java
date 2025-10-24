class Solution {
    public int nextBeautifulNumber(int n) {
        int maxlen = String.valueOf(n).length();
        maxlen++;
        PriorityQueue<Integer> pq = new PriorityQueue<>(); 
        helper(n, 0, pq, maxlen, new int[10]);

        return pq.isEmpty() ? -1 : pq.peek(); 
    }

    public void helper(int n, int num, PriorityQueue<Integer> pq, int maxlen, int[] freq) {
        
        if (num != 0 && num > n && balanced(freq)) {
            pq.offer(num);
        }

        
        if (String.valueOf(num).length() > maxlen || num > 1223333) {
            return;
        }

        
        for (int i = 1; i <= 7; i++) {
            if(freq[i] < i)
            {

            freq[i]++;
            helper(n, num * 10 + i, pq, maxlen, freq);
            freq[i]--;
            }
        }
    }

    private boolean balanced(int[] count) {
        for (int d = 1; d <= 7; d++) {
            if (count[d] != 0 && count[d] != d) return false;
        }
        return true;
    }
}
