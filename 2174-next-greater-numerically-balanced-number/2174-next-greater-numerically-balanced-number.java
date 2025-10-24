class Solution {
    int res = Integer.MAX_VALUE; 

    public int nextBeautifulNumber(int n) {
        int maxlen = String.valueOf(n).length() + 1;
        helper(n, 0, maxlen, new int[10]);
        return res;
    }

    public void helper(int n, int num, int maxlen, int[] freq) {
        
        if (num > n && balanced(freq)) {
            res = Math.min(res, num);
        }

        
        if (String.valueOf(num).length() > maxlen || num > 1223333) {
            return;
        }

        
        for (int i = 1; i <= 7; i++) {
            if (freq[i] < i) { 
                freq[i]++;
                helper(n, num * 10 + i, maxlen, freq);
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
