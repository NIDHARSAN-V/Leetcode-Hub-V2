class Solution {
    long mod = 1000000007;
    public int countGoodNumbers(long n) {
        long even = (n+1)/2;
        long odd  = n/2;
        return (int)((helper(5 ,even ) * helper(4,odd))%mod);
    }


    private long  helper(long num , long cat)
    {
        long res= 1;
        while(cat > 0)
        {
            if((cat &  1)==1)
            {
                res =  (res * num)%mod;
            }
            num = (num * num) % mod;
            cat>>=1;
        }


        return res%mod;
        
    }
}