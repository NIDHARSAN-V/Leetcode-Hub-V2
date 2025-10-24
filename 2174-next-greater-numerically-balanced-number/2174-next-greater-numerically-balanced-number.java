class Solution {
    
    int res = Integer.MIN_VALUE;
    public int nextBeautifulNumber(int n) 
    {
        int x = n + 1;
        while (true) {
            if (isBalanced(x)) return x;
            x++;
        }
       
    }

   boolean isBalanced(int num) {
        int[] freq = new int[10];
        char[] arr = String.valueOf(num).toCharArray();
        for (char c : arr) freq[c - '0']++;

        for (int i = 0; i < 10; i++) {
            if (freq[i] > 0 && freq[i] != i) return false;
        }
        return true;
    }

}