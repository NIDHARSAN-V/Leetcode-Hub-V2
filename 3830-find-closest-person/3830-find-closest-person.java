class Solution {
    public int findClosest(int x, int y, int z) {
        
        int min  = 1;
        int cur  = Math.abs(x-z);
        int yd = Math.abs(y-z);
        if(cur == yd)
        {
            min =0;
        }
        else if(cur > yd)
        {
            min =2;
        }
        return min;
    }
}