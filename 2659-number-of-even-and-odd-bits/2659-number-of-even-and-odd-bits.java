class Solution {
    public int[] evenOddBit(int n) {
        int[] res =  new int[2];
        Boolean val = true;
        int even=0;
        int odd=0;
         while(n!=0)
         {
            int x = n&1;
            if(val && x==1)
                odd++;
            if(!val && x==1)
                even++;

            val = !val;
            n = n>>1;
                
            
         }
         res[0] = odd;
         res[1] = even;
         return res;
    }
}