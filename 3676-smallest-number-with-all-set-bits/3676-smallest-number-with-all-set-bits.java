class Solution {
    public int smallestNumber(int n) {
        int pow =0;
        while(n!=0)
        {
            n = n>>1;
            pow++;
        }
        return (int)(Math.pow(2 , pow) - 1);
    }
}