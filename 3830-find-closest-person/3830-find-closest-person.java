class Solution {
    public int findClosest(int x, int y, int z) {
        
        int min  = 1;
        int cur  = Math.abs(x-z);
        if(cur == Math.abs(y-z))
        {
            min =0;
        }
        else if(cur > Math.abs(y-z))
        {
            min =2;
        }
        return min;
    }
}