class Solution {
    public int binaryGap(int n) {
          int last = -1;  
        int maxDist = 0;
        int index = 0;

        while (n > 0) {
            if ((n & 1) == 1) {  
                if (last != -1) {
                    maxDist = Math.max(maxDist, index - last);
                }
                last = index;
            }
            n >>= 1;  
            index++;
        }

        return maxDist;
    }
}