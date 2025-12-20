class Solution {
    public int minDeletionSize(String[] strs) {
        int r = strs.length;
        int c = strs[0].length();
        int res = 0;

        for (int i = 0; i < c; i++) {         
            for (int j = 0; j < r - 1; j++) {  
                if (strs[j].charAt(i) > strs[j + 1].charAt(i)) {
                    res++;                    
                    break;                    
                }
            }
        }
        return res;
    }
}
