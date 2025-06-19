public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0;

        for(int i = 0; i < 32; i++) {
            res = res << 1;         // Step 1: shift result left by 1 bit (make room for next bit)
            res = res | (n & 1);    // Step 2: add the last bit of n to res
            n = n >>> 1;            // Step 3: unsigned right shift n to process next bit
        }

        return res;
    }
}
