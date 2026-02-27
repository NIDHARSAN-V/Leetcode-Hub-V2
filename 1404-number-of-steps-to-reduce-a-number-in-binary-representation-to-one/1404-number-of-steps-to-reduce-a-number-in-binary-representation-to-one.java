class Solution {
    public int numSteps(String s) {
        int onecount = 0;
        int ans = 0;
        int carry  =0;
        for(int i = s.length()-1 ; i >0 ; i--)
        {
           int b = (s.charAt(i) - '0') + carry;
           if(b==1)
           {
               ans+=2;
               carry = 1;
           }
           else
           {
             ans+=1;
           }
        }

        return ans + carry;
    }
}